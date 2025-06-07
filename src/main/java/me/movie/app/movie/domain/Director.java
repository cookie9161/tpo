package me.movie.app.movie.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.movie.dto.DirectorRequestDTO;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "Director")
class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "secondName", nullable = false)
    private String lastName;

    @Column(name = "birthDate", nullable = false)
    private LocalDate birthDate;

    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Movie> movies;

    public static Director createDirector(DirectorRequestDTO directorRequestDTO) {
        return Director.builder()
                .firstName(directorRequestDTO.getFirstName())
                .lastName(directorRequestDTO.getLastName())
                .birthDate(directorRequestDTO.getBirthDate())
                .movies(new HashSet<>())
                .build();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
        movie.setDirector(this);
    }
}
