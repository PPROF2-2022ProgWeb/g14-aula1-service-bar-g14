package com.servicebar.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servicebar.backend.models.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    
}
