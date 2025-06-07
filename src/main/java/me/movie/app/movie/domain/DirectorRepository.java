package me.movie.app.movie.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface DirectorRepository extends JpaRepository<Director, Long> {
    Optional<Director> findByFirstNameAndLastName(String firstName, String lastName);
}
