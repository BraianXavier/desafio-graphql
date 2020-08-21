package com.example.desafiographql.domain.services;

import com.example.desafiographql.domain.model.Tarefa;
import com.example.desafiographql.domain.repositories.TarefaRepository;
import com.example.desafiographql.domain.repositories.UsuarioRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Tarefa create(Tarefa tarefa, String email) {
        tarefa.setUsuario(usuarioRepository.findByEmail(email).get());
        return tarefaRepository.save(tarefa);
    }

        public Optional<Tarefa> findTarefaByName(String name){
        return tarefaRepository.findByName(name);
    }

    public Tarefa update(String status, Long id) {
        Optional<Tarefa> optTarefa = tarefaRepository.findById(id);
        Tarefa tarefa = optTarefa.get();
        tarefa.setStatus(status);
        tarefaRepository.save(tarefa);
        return tarefa;
    }

}
