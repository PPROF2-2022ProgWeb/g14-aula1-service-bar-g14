package com.servicebar.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servicebar.backend.models.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long>{
    
}
