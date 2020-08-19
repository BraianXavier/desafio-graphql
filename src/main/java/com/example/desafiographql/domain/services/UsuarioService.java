package com.example.desafiographql.domain.services;


import com.example.desafiographql.domain.model.Usuario;
import com.example.desafiographql.domain.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void createUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }

//    public Optional<Usuario> findUsuarioByEmail(String email){
//        return usuarioRepository.findByEmail(email);
//    }

}
