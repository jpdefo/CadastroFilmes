package com.example.movies.Exceptions;

public class ActorNotFoundExceptionBuilder {
    private String response;

    public ActorNotFoundExceptionBuilder setResponse(String response) {
        this.response = response;
        return this;
    }

    public ActorNotFoundException createActorNotFoundException() {
        return new ActorNotFoundException(response);
    }
}