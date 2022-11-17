package com.servicebar.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servicebar.backend.models.Reserva;

import java.util.List;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Long> {
    List<Reserva> findByIdCliente(int idCliente);
}
