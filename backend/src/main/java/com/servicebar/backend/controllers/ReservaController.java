package com.servicebar.backend.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.servicebar.backend.models.Reserva;
import com.servicebar.backend.repositories.ReservaRepository;


@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@EnableAutoConfiguration
public class ReservaController {
    private final ReservaRepository repository;
    ReservaController(ReservaRepository repository) {
        this.repository = repository;
    }

    @GetMapping(
        value = "/api/reserva",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Iterable<Reserva> getReservas(@RequestParam(value="idCliente") int idCliente) {

        return repository.findByIdCliente(idCliente);
    }

    @GetMapping(
        value = "/api/reserva/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Reserva getReservaById(@PathVariable("id") long id) {
        Reserva reserva = repository.findById(id).orElse(null);
        if(reserva == null) {
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        return reserva;
    }

    @PostMapping(
        value = "/api/reserva",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Reserva postReserva(@RequestBody Reserva reserva) {
        repository.save(reserva);
        return reserva;
    }

    @PutMapping(
        value = "/api/reserva",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Reserva putReserva(@RequestBody Reserva reserva) {
        Reserva reservaAct = repository.findById(reserva.getIdReserva()).orElse(null);
        if(reservaAct == null) {
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        repository.save(reserva);
        return reserva;
    }

    @DeleteMapping(
        value = "/api/reserva/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Reserva deleteReserva(@PathVariable("id") long id) {
        Reserva reserva = repository.findById(id).orElse(null);
        if(reserva == null) {
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        repository.deleteById(id);
        return reserva;
    }
}
