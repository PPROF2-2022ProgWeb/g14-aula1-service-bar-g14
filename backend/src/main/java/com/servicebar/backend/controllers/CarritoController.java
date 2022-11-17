package com.servicebar.backend.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.servicebar.backend.models.Carrito;
import com.servicebar.backend.repositories.CarritoRepository;


@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@EnableAutoConfiguration
public class CarritoController {
    private final CarritoRepository repository;
    CarritoController(CarritoRepository repository) {
        this.repository = repository;
    }

    @GetMapping(
        value = "/api/carrito",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Iterable<Carrito> getCarritos() {
        return repository.findAll();
    }

    @GetMapping(
        value = "/api/carrito/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Carrito getCarritoById(@PathVariable("id") long id) {
        Carrito carrito = repository.findById(id).orElse(null);
        if(carrito == null) {
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        return carrito;
    }

    @PostMapping(
        value = "/api/carrito",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Carrito postCarrito(@RequestBody Carrito carrito) {
        repository.save(carrito);
        return carrito;
    }

    @PutMapping(
        value = "/api/carrito",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Carrito putCarrito(@RequestBody Carrito carrito) {
        Carrito carritoAct = repository.findById(carrito.getIdCarrito()).orElse(null);
        if(carritoAct == null) {
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        repository.save(carrito);
        return carrito;
    }

    @DeleteMapping(
        value = "/api/carrito/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Carrito deleteCarrito(@PathVariable("id") long id) {
        Carrito carrito = repository.findById(id).orElse(null);
        if(carrito == null) {
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        repository.deleteById(id);
        return carrito;
    }
}
