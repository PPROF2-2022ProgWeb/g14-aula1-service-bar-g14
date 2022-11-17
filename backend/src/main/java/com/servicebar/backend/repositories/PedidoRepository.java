package com.servicebar.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servicebar.backend.models.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {
    
}
