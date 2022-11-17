package com.servicebar.backend.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.servicebar.backend.models.MetodoPago;
import com.servicebar.backend.repositories.MetodoPagoRepository;


@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@EnableAutoConfiguration
public class MetodoPagoController {
    private final MetodoPagoRepository repository;
    MetodoPagoController(MetodoPagoRepository repository) {
        this.repository = repository;
    }

    @GetMapping(
        value = "/api/metodo-pago",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Iterable<MetodoPago> getMetodoPago() {
        return repository.findAll();
    }

    @GetMapping
    (
        value = "/api/metodo-pago/{id}",        
        produces = MediaType.APPLICATION_JSON_VALUE

    )
    MetodoPago getMetodoPagoById(@PathVariable("id") long id) {
        MetodoPago metodoPago = repository.findById(id).orElse(null);
        if(metodoPago == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
                );
        }
        return metodoPago;
    }

    @PostMapping(
        value = "/api/metodo-pago",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    MetodoPago postMetodoPago(@RequestBody MetodoPago metodoPago) {
        repository.save(metodoPago);
        return metodoPago;
    }

    @PutMapping(
        value = "/api/metodo-pago",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    MetodoPago putMetodoPago(@RequestBody MetodoPago metodoPago) {
        MetodoPago metodoPagoAct = repository.findById(metodoPago.getIdMetodoPago()).orElse(null);
        if(metodoPagoAct == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
                );
        }
        repository.save(metodoPago);
        return metodoPago;
    }

    @DeleteMapping(
        value = "/api/metodo-pago/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    MetodoPago deleteMetodoPago(@PathVariable("id")long id) {
        MetodoPago metodoPago = repository.findById(id).orElse(null);
        if(metodoPago == null) {
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        repository.deleteById(id);
        return metodoPago;
    }
}
