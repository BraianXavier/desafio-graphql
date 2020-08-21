package com.example.desafiographql;

import com.example.desafiographql.domain.model.Tarefa;
import com.example.desafiographql.domain.model.Usuario;
import com.example.desafiographql.domain.repositories.TarefaRepository;
import com.example.desafiographql.domain.services.UsuarioService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import javax.validation.ConstraintViolationException;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TarefaRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TarefaRepository tarefaRepository;

    @Test
    public void quandoFindByName_DeveRetornar() {
        // given
        Usuario usuario = new Usuario("nome", "email");
        entityManager.persist(usuario);
        Tarefa objetoTarefa = new Tarefa();
        objetoTarefa.setName("teste integração");
        objetoTarefa.setDescricao("teste descricao");
        objetoTarefa.setStatus("feito");
        objetoTarefa.setUsuario(usuario);
        entityManager.persist(objetoTarefa);
        entityManager.flush();
        // when
       Optional<Tarefa> tarefaEncontrada = tarefaRepository.findByName(objetoTarefa.getName());


       tarefaEncontrada.ifPresent(tarefa ->{
           assertEquals(tarefa.getName(), objetoTarefa.getName());
       });
        // then

    }

    @Test(expected = ConstraintViolationException.class)
    public void casoNameNull_DeveDarErro() {
        Tarefa objetoTarefa = new Tarefa();
        objetoTarefa.setStatus("feito");
        objetoTarefa.setDescricao("teste teste teste ");
        entityManager.persist(objetoTarefa);
        entityManager.flush();
    }
    @Test(expected = ConstraintViolationException.class)
    public void casoDescricaoNull_DeveDarErro() {
        Tarefa objetoTarefa = new Tarefa();
        objetoTarefa.setName("teste");
        objetoTarefa.setStatus("feito");
        entityManager.persist(objetoTarefa);
        entityManager.flush();
    }
    @Test(expected = ConstraintViolationException.class)
    public void casoStatusNull_DeveDarErro() {
        Tarefa objetoTarefa = new Tarefa();
        objetoTarefa.setName("teste");
        objetoTarefa.setDescricao("teste teste teste");
        entityManager.persist(objetoTarefa);
        entityManager.flush();
    }

    @Test(expected = ConstraintViolationException.class)
    public void casoUsuarioNull_DeveDarErro() {
        Tarefa objetoTarefa = new Tarefa();
        objetoTarefa.setName("teste");
        objetoTarefa.setStatus("feito");
        objetoTarefa.setDescricao("feito feito feito");
        entityManager.persist(objetoTarefa);
        entityManager.flush();
    }

    }
