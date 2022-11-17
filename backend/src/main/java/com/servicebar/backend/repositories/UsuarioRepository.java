package com.servicebar.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servicebar.backend.models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
    Usuario findByEmail(String email);
}
