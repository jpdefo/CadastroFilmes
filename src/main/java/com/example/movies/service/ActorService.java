package com.example.movies.service;
import com.example.movies.dominio.Actor;
import com.example.movies.repository.ActorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ActorService {
    private ActorRepository actorRepository;

    public Actor addActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public List<Actor> actorsList() {
        return actorRepository.findAll();
    }

    public Actor SearchByID(Long id) {
        Optional<Actor> AtorOptional = actorRepository.findById(id);
        if (AtorOptional.isEmpty()) {
            throw new IllegalArgumentException("Id não é valido");
        }
        return AtorOptional.get();
    }

    public Actor buscaPorNome(String nome) {
        Optional<Actor> AtorOptional = actorRepository.findByName(nome);
        if (AtorOptional.isEmpty()) {
            throw new IllegalArgumentException("Nome não é valido");
        }
        return AtorOptional.get();
    }

    public Actor removeAtor(Long id) {
        Actor actor = this.SearchByID(id);
        actorRepository.delete(actor);
        return actor;
    }

    public Actor atualizaAtor(Actor novoActor) {
        Actor actorBanco = this.SearchByID(novoActor.getId());
        actorBanco.setName(actorBanco.getName());

        return this.addActor(actorBanco);
    }
}
