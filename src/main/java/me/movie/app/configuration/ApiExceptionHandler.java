package me.movie.app.configuration;

import jakarta.persistence.EntityNotFoundException;
import me.movie.app.configuration.exception.MovieNotFoundException;
import me.movie.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> entityNotFoundExceptionHandler() {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ErrorResponseDTO response = buildErrorResponse(httpStatus, "Entity not found");
        return ResponseEntity.status(httpStatus).body(response);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponseDTO> illegalArgumentExceptionHandler() {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ErrorResponseDTO response = buildErrorResponse(httpStatus, "Invalid request");
        return ResponseEntity.status(httpStatus).body(response);
    }

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> MovieNotFoundExceptionHandler(MovieNotFoundException exception) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ErrorResponseDTO response = buildErrorResponse(httpStatus, exception.getMessage());
        return ResponseEntity.status(httpStatus).body(response);
    }

    private static ErrorResponseDTO buildErrorResponse(HttpStatus status, String message) {
        return ErrorResponseDTO.builder()
                .timestamp(LocalDateTime.now())
                .status(status.value())
                .error(status.getReasonPhrase())
                .message(message)
                .build();
    }
}