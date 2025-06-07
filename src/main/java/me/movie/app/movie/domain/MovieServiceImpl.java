package me.movie.app.movie.domain;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import me.movie.app.configuration.exception.MovieNotFoundException;
import me.movie.dto.*;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;
    private final MovieMapper movieMapper;

    @Override
    public List<MovieResponseDTO> getMovies(String sortMoviesBy) {
        if (sortMoviesBy == null) {
            sortMoviesBy = "title";
        }

        return movieRepository.findAll(Sort.by(sortMoviesBy))
                .stream()
                .map(movieMapper::map)
                .toList();
    }

    @Override
    public MovieResponseDTO getMovie(Long id) {
        return movieRepository.findById(id)
                .map(movieMapper::map)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found"));
    }

    @Override
    public MovieResponseDTO createMovie(MovieCreateRequestDTO movieDTO) {
        Movie movie = Movie.createMovie(movieDTO);

        DirectorRequestDTO directorDTO = movieDTO.getDirector();
        Optional<Director> directorFound = directorRepository.findByFirstNameAndLastName(
                directorDTO.getFirstName(), directorDTO.getLastName()
        );

        Director director = directorFound.orElseGet( () ->
                        directorRepository.save(Director.createDirector(directorDTO))
                );

        director.addMovie(movie);
        Movie savedMovie = movieRepository.save(movie);

        return movieMapper.map(savedMovie);
    }

    @Override
    public MovieResponseDTO updateMovie(Long id, MovieUpdateRequestDTO movieDTO) {
        Movie movie = findMovieById(id);
        movie.updateMovie(movieDTO);

        movieRepository.save(movie);
        return movieMapper.map(movie);
    }

    @Override
    public MovieIdResponseDTO deleteMovie(Long id) {
        Movie movie = findMovieById(id);

        movieRepository.delete(movie);

        return MovieIdResponseDTO.builder().id(id).build();
    }

    private Movie findMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Could not find a movier by id:" + id));
    }
}
