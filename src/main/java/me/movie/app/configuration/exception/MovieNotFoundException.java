package me.movie.app.configuration.exception;

import jakarta.persistence.PersistenceException;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MovieNotFoundException extends PersistenceException {
    public MovieNotFoundException(String message) {
        super(message);
    }
}
