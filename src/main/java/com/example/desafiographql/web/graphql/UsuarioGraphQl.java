package com.example.desafiographql.web.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.desafiographql.domain.model.Usuario;
import com.example.desafiographql.domain.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsuarioGraphQl implements GraphQLMutationResolver, GraphQLQueryResolver {

    @Autowired
    private UsuarioService usuarioService;

    public void createUsuario(Usuario usuario){
        usuarioService.createUsuario(usuario);
    }
//    public Optional<Usuario> findUsuario(String email){
//        return usuarioService.findUsuarioByEmail(email);
//    }
}
