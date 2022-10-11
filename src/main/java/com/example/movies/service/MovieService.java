package com.example.movies.service;
import com.example.movies.Exceptions.MovieNotFoundExceptionBuilder;
import com.example.movies.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieRepository.Movie addMovie(MovieRepository.Movie movie) {
        return movieRepository.save(movie);
    }

    public List<MovieRepository.Movie> listMovies() {
        return movieRepository.findAll();
    }

    public MovieRepository.Movie searchByID(Long id) {
        Optional<MovieRepository.Movie> filmeOptional = movieRepository.findById(id);
        if (filmeOptional.isEmpty()) {
            throw new MovieNotFoundExceptionBuilder().setResponse("Id não é valido").createMovieNotFoundException();
        }
        return filmeOptional.get();
    }

    public MovieRepository.Movie searchByName(String nome) {
        Optional<MovieRepository.Movie> filmeOptional = movieRepository.findByName(nome);
        if (filmeOptional.isEmpty()) {
            throw new MovieNotFoundExceptionBuilder().setResponse("Nome não é valido").createMovieNotFoundException();
        }
        return filmeOptional.get();
    }

    public List<MovieRepository.Movie> searchByGenre(String genero) {
        Optional<List<MovieRepository.Movie>> filmeOptional = movieRepository.findByGenre(genero);
        if (filmeOptional.isEmpty()) {
            throw new MovieNotFoundExceptionBuilder().setResponse("Genero não é valido").createMovieNotFoundException();
        }
        return filmeOptional.get();
    }

    public List<MovieRepository.Movie> searchByYear(String ano) {
        Optional<List<MovieRepository.Movie>> filmeOptional = movieRepository.findByReleaseDate(ano);
        if (filmeOptional.isEmpty()) {
            throw new MovieNotFoundExceptionBuilder().setResponse("Ano não é valido").createMovieNotFoundException();
        }
        return filmeOptional.get();
    }

    public MovieRepository.Movie removeMovie(Long id) {
        MovieRepository.Movie movie = this.searchByID(id);
        movieRepository.delete(movie);
        return movie;
    }

    public MovieRepository.Movie updateMovie(MovieRepository.Movie novoMovie) {
        MovieRepository.Movie movieBanco = this.searchByID(novoMovie.getId());

        movieBanco.setName(novoMovie.getName());
        movieBanco.setGenre(novoMovie.getGenre());
        movieBanco.setReleaseDate(novoMovie.getReleaseDate());
        movieBanco.setActorsList(novoMovie.getActorsList());
        return this.addMovie(movieBanco);
    }
}
