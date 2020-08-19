package com.example.desafiographql.domain.repositories;

import com.example.desafiographql.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
//    Optional<Usuario> findByEmail(String email);
}
