package me.movie.app.movie.domain;

import me.movie.dto.MovieCreateRequestDTO;
import me.movie.dto.MovieResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
interface MovieMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "releaseDate", source = "releaseDate")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "rating", source = "rating")
    @Mapping(target = "duration", source = "duration")
    @Mapping(target = "genre", source = "genre")
    @Mapping(target = "director", source = "director")
    MovieResponseDTO map(Movie movie);

    Movie map(MovieCreateRequestDTO movieRequestDTO);
}
