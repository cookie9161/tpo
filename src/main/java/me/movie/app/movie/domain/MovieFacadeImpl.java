package me.movie.app.movie.domain;

import lombok.RequiredArgsConstructor;
import me.movie.dto.MovieCreateRequestDTO;
import me.movie.dto.MovieIdResponseDTO;
import me.movie.dto.MovieResponseDTO;
import me.movie.dto.MovieUpdateRequestDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
class MovieFacadeImpl implements MovieFacade {
    private final MovieService movieService;

    @Override
    public List<MovieResponseDTO> getMovies(String sortMoviesBy) {
        return movieService.getMovies(sortMoviesBy);
    }

    @Override
    public MovieResponseDTO getMovie(Long id) {
        return movieService.getMovie(id);
    }

    @Override
    public MovieResponseDTO createMovie(MovieCreateRequestDTO movieDTO) {
        return movieService.createMovie(movieDTO);
    }

    @Override
    public MovieResponseDTO updateMovie(Long id, MovieUpdateRequestDTO movieDTO) {
        return movieService.updateMovie(id, movieDTO);
    }

    @Override
    public MovieIdResponseDTO deleteMovie(Long id) {
        return movieService.deleteMovie(id);
    }
}