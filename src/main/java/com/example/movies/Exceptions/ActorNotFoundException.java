package com.example.movies.Exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ActorNotFoundException extends ResponseStatusException {
    private final String response;

    public ActorNotFoundException(String response) {
        super(HttpStatus.NOT_FOUND, response);
        this.response = response;
    }
}
