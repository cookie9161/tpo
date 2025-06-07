package me.movie.app.movie.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface MovieRepository extends JpaRepository<Movie, Long> {
}
