package com.example.movies.controller;
import com.example.movies.dominio.Actor;
import com.example.movies.service.ActorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
@AllArgsConstructor
public class ActorController {
    private final ActorService actorService;

    @PostMapping
    public ResponseEntity<Actor> addActor(@RequestBody Actor actor) {
        actorService.addActor(actor);
        return new ResponseEntity<>(actor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> SearchActorByID(@PathVariable Long id) {
        Actor actor = actorService.SearchByID(id);
        return new ResponseEntity<>(actor, HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<Actor> updateActor(@RequestBody Actor newActor) {
        Actor actor = actorService.atualizaAtor(newActor);
        return new ResponseEntity<>(actor, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Actor> SearchActorByID(@PathVariable String name) {
        Actor actor = actorService.buscaPorNome(name);
        return new ResponseEntity<>(actor, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Actor>> actorsList() {
        List<Actor> actorsList = actorService.actorsList();
        return new ResponseEntity<>(actorsList, HttpStatus.OK);
    }
}
