package com.servicebar.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servicebar.backend.models.MetodoPago;

@Repository
public interface MetodoPagoRepository extends CrudRepository<MetodoPago, Long> {
    
}
