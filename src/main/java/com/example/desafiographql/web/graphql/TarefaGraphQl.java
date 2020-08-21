package com.example.desafiographql.web.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.desafiographql.domain.model.Tarefa;
import com.example.desafiographql.domain.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TarefaGraphQl implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private TarefaService tarefaService;


    public Tarefa createTarefa(Tarefa tarefa, String email){
        return tarefaService.create(tarefa,email);
    }

    public Optional<Tarefa> findTarefa(String name){
        return tarefaService.findTarefaByName(name);
    }

    public Tarefa alteraStatus(Long id,String status){
        return tarefaService.update(status,id);
    }
}
