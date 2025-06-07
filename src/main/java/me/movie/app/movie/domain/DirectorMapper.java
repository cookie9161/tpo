package me.movie.app.movie.domain;

import me.movie.dto.DirectorRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface DirectorMapper {

    Director map(DirectorRequestDTO directorRequestDTO);
}
