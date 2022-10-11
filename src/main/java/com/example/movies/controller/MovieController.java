package com.example.movies.controller;
import com.example.movies.repository.MovieRepository;
import com.example.movies.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieRepository.Movie> addMovie(@RequestBody MovieRepository.Movie movie) {
        MovieRepository.Movie movieAdded = movieService.addMovie(movie);
        return new ResponseEntity<>(movieAdded, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieRepository.Movie> searchMovieByID(@PathVariable Long id) {
        MovieRepository.Movie movie = movieService.searchByID(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<MovieRepository.Movie> searchMovieByName(@PathVariable String name) {
        MovieRepository.Movie movie = movieService.searchByName(name);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MovieRepository.Movie> updateMovie(@RequestBody MovieRepository.Movie newMovie) {
        MovieRepository.Movie movie = movieService.updateMovie(newMovie);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }
    @GetMapping("/{genre}")
    public ResponseEntity<MovieRepository.Movie> searchMovieByGenre(@PathVariable String genre) {
        List<MovieRepository.Movie> movie = movieService.searchByGenre(genre);
        return new ResponseEntity<>(movie.get(0), HttpStatus.OK);
    }

    @GetMapping("/{year}")
    public ResponseEntity<MovieRepository.Movie> searchMovieByYear(@PathVariable String year) {
        List<MovieRepository.Movie> movie = movieService.searchByYear(year);
        return new ResponseEntity<>(movie.get(0), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MovieRepository.Movie>> listMovies() {
        List<MovieRepository.Movie> listMovies = movieService.listMovies();
        return new ResponseEntity<>(listMovies, HttpStatus.OK);
    }

}
