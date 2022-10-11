package com.example.movies.Exceptions;

public class MovieNotFoundExceptionBuilder {
    private String response;

    public MovieNotFoundExceptionBuilder setResponse(String response) {
        this.response = response;
        return this;
    }

    public MovieNotFoundException createMovieNotFoundException() {
        return new MovieNotFoundException(response);
    }
}