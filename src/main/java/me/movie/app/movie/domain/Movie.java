package me.movie.app.movie.domain;

import jakarta.persistence.*;
import lombok.*;
import me.movie.dto.MovieGenreDTO;
import me.movie.dto.MovieCreateRequestDTO;
import me.movie.dto.MovieStatusDTO;
import me.movie.dto.MovieUpdateRequestDTO;

import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "Movie")
class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(name = "releaseDate",nullable = false)
    private LocalDate releaseDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MovieStatusDTO status;

    @Column(nullable = false)
    private Double rating;

    @Column(nullable = false)
    private Integer duration;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MovieGenreDTO genre;

    @Column(nullable = false)
    private String language;

    @ManyToOne
    @JoinColumn(name = "directorId", referencedColumnName = "id", nullable = false)
    @Setter
    private Director director;

    @Column(name = "createDate", nullable = false)
    private LocalDate createDate;

    public static Movie createMovie(MovieCreateRequestDTO movieDto) {
        return Movie.builder()
                .title(movieDto.getTitle())
                .description(movieDto.getDescription())
                .releaseDate(movieDto.getReleaseDate())
                .status(MovieStatusDTO.AVAILABLE)
                .rating(movieDto.getRating())
                .duration(movieDto.getDuration())
                .genre(movieDto.getGenre())
                .language(movieDto.getLanguage())
                .createDate(LocalDate.now())
                .build();
    }

    public void updateMovie(MovieUpdateRequestDTO movieDTO) {
        this.title = movieDTO.getTitle();
        this.description = movieDTO.getDescription();
        this.releaseDate = movieDTO.getReleaseDate();
        this.rating = movieDTO.getRating();
        this.duration = movieDTO.getDuration();
        this.genre = movieDTO.getGenre();
        this.language = movieDTO.getLanguage();
    }
}
