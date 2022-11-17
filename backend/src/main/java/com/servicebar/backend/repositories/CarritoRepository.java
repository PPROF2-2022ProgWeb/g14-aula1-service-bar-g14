package com.servicebar.backend.repositories;

import org.springframework.stereotype.Repository;

import com.servicebar.backend.models.Carrito;

import org.springframework.data.repository.CrudRepository;;

@Repository
public interface CarritoRepository extends CrudRepository<Carrito, Long> { 
    
}
