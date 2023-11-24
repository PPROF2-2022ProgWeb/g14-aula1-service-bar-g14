package com.servicebar.backend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.servicebar.backend.models.Cliente;
import com.servicebar.backend.repositories.ClienteRepository;


@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@EnableAutoConfiguration
public class ClienteController {
    private final ClienteRepository repository;
    ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @GetMapping(
        value = "/api/cliente",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Iterable<Cliente> getCliente() {
        return repository.findAll();
    }

    @GetMapping(
        value = "/api/cliente/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Cliente getClienteById(@PathVariable("id") long id) {
        Cliente cliente = repository.findById(id).orElse(null);
        if(cliente == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
                );
        }
        return cliente;
    }

    @PostMapping(
        value = "/api/cliente",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Cliente postCliente(@RequestBody Cliente cliente) {
        repository.save(cliente);
        return cliente;
    }

    @PutMapping(
        value = "/api/cliente",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Cliente putCliente(@RequestBody Cliente cliente) {
        Cliente clienteAct = repository.findById(cliente.getIdCliente()).orElse(null);
        if(clienteAct == null) {
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        repository.save(cliente);
        return cliente;
    }

    @DeleteMapping(
        value = "/api/cliente/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Cliente deleteCliente(@PathVariable("id") long id) {
        Cliente cliente = repository.findById(id).orElse(null);
        if(cliente == null) {
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        repository.deleteById(id);
        return cliente;
    }
}
