package me.movie.app.movie.api;

import lombok.RequiredArgsConstructor;
import me.movie.api.MovieApi;
import me.movie.app.movie.domain.MovieFacade;
import me.movie.dto.MovieCreateRequestDTO;
import me.movie.dto.MovieIdResponseDTO;
import me.movie.dto.MovieResponseDTO;
import me.movie.dto.MovieUpdateRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController implements MovieApi {
    private final MovieFacade movieFacade;

    @Override
    public ResponseEntity<List<MovieResponseDTO>> getMovies(String sort) {
        return ResponseEntity.ok().body(movieFacade.getMovies(sort));
    }

    @Override
    public ResponseEntity<MovieResponseDTO> getMovie(Long id) {
        return ResponseEntity.ok().body(movieFacade.getMovie(id));
    }

    @Override
    public ResponseEntity<MovieResponseDTO> createMovie(MovieCreateRequestDTO movieDTO) {
        return ResponseEntity.ok().body(movieFacade.createMovie(movieDTO));
    }

    @Override
    public ResponseEntity<MovieResponseDTO> updateMovie(Long id, MovieUpdateRequestDTO movieDTO) {
        return ResponseEntity.ok().body(movieFacade.updateMovie(id, movieDTO));
    }

    @Override
    public ResponseEntity<MovieIdResponseDTO> deleteMovie(Long id) {
        return ResponseEntity.ok().body(movieFacade.deleteMovie(id));
    }
}