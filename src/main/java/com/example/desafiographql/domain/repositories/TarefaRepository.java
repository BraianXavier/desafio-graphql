package com.example.desafiographql.domain.repositories;

import com.example.desafiographql.domain.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TarefaRepository extends JpaRepository<Tarefa,Long> {
    Optional<Tarefa> findByName(String name);
    Optional<Tarefa> findById(Long id);
}
