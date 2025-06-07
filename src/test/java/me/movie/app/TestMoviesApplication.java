package me.movie.app;

import org.springframework.boot.SpringApplication;

public class TestMoviesApplication {

	public static void main(String[] args) {
		SpringApplication.from(MoviesApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
