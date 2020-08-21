package com.example.desafiographql;

import com.example.desafiographql.domain.model.Tarefa;
import com.example.desafiographql.domain.model.Usuario;
import com.example.desafiographql.domain.repositories.UsuarioRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UsuarioRepositoryIntegrationTest {

        @Autowired
        private TestEntityManager entityManager;
        @Autowired
        private UsuarioRepository usuarioRepository;

    @Test
    public void quandoFindByEmail_DeveRetornar() {
        // given
        Usuario objetoUsuario = new Usuario();
        objetoUsuario.setEmail("test@test.com");
        objetoUsuario.setName("teste");
        entityManager.persist(objetoUsuario);
        entityManager.flush();

        // when
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findByEmail(objetoUsuario.getEmail());


        usuarioEncontrado.ifPresent(usuario ->{
            assertEquals(usuario.getEmail(), objetoUsuario.getEmail());
        });
        // then

    }

    @Test(expected = ConstraintViolationException.class)
    public void casoNameNull_DeveDarErro(){
        Usuario objetoUsuario = new Usuario();
        objetoUsuario.setEmail("teste@teste.com");
        entityManager.persist(objetoUsuario);
        entityManager.flush();
    }
    @Test(expected = ConstraintViolationException.class)
    public void casoEmailNull_DeveDarErro(){
        Usuario objetoUsuario = new Usuario();
        objetoUsuario.setName("teste");
        entityManager.persist(objetoUsuario);
        entityManager.flush();
    }

}
