package com.example.movies.Exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MovieNotFoundException extends ResponseStatusException {

    private final String response;

    public MovieNotFoundException(String response) {
        super(HttpStatus.NOT_FOUND, response);
        this.response = response;
    }
}
