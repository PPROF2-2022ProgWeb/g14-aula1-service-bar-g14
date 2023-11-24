package com.servicebar.backend.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.servicebar.backend.models.Pedido;
import com.servicebar.backend.repositories.PedidoRepository;


@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@EnableAutoConfiguration
public class PedidoController {
    private final PedidoRepository repository;
    PedidoController(PedidoRepository repository) {
        this.repository = repository;
    }

    @GetMapping(
        value = "/api/pedido",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Iterable<Pedido> getPedidos() {
        return repository.findAll();
    }

    @GetMapping(
        value = "/api/pedido/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Pedido getPedidoById(@PathVariable("id") long id) {
        Pedido pedido = repository.findById(id).orElse(null);
        if(pedido == null) {
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        return pedido;
    }

    @PostMapping(
        value = "/api/pedido",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Pedido postPedido(@RequestBody Pedido pedido) {
        repository.save(pedido);
        return pedido;
    }

    @PutMapping(
        value = "/api/pedido",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Pedido putPedido(@RequestBody Pedido pedido) {
        Pedido pedidoAct = repository.findById(pedido.getIdPedido()).orElse(null);
        if(pedidoAct == null) {
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        repository.save(pedido);
        return pedido;
    }

    @DeleteMapping(
        value = "/api/pedido/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Pedido deletePedido(@PathVariable("id") long id) {
        Pedido pedido = repository.findById(id).orElse(null);
        if(pedido == null) {
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        repository.deleteById(id);
        return pedido;
    }
}
