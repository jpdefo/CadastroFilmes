package com.example.movies.repository;
import com.example.movies.dominio.Actor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

public interface MovieRepository extends JpaRepository<MovieRepository.Movie, Long> {
    @Entity
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class Movie {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @NotBlank
        private String name;
        @NotBlank
        private String genre;
        @NotBlank
        private LocalDate releaseDate;
        @OneToMany
        private List<Actor> actorsList;


    }
}
