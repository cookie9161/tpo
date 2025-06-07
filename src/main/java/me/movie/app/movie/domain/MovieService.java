package me.movie.app.movie.domain;


import me.movie.dto.MovieCreateRequestDTO;
import me.movie.dto.MovieIdResponseDTO;
import me.movie.dto.MovieResponseDTO;
import me.movie.dto.MovieUpdateRequestDTO;

import java.util.List;

interface MovieService {
    List<MovieResponseDTO> getMovies(String sortMoviesBy);
    MovieResponseDTO getMovie(Long id);
    MovieResponseDTO createMovie(MovieCreateRequestDTO movieDTO);
    MovieResponseDTO updateMovie(Long id, MovieUpdateRequestDTO movieDTO);
    MovieIdResponseDTO deleteMovie(Long id);
}
