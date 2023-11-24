package com.servicebar.backend.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.servicebar.backend.models.Producto;
import com.servicebar.backend.repositories.ProductoRepository;


@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@EnableAutoConfiguration
public class ProductoController {
    private final ProductoRepository repository;
    ProductoController(ProductoRepository repository) {
        this.repository = repository;
    }

    @GetMapping(
        value = "/api/producto",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Iterable<Producto> getProductos() {
        return repository.findAll();
    }

    @GetMapping(
        value = "/api/producto/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Producto getProductoById(@PathVariable("id") long id) {
        Producto producto = repository.findById(id).orElse(null);
        if(producto == null) {
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        return producto;
    }

    @PostMapping(
        value = "/api/producto",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Producto postProducto(@RequestBody Producto producto) {
        repository.save(producto);
        return producto;
    }

    @PutMapping(
        value = "/api/producto",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Producto putProducto(@RequestBody Producto producto) {
        Producto productoAct = repository.findById(producto.getIdProducto()).orElse(null);
        if(productoAct == null) {
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        repository.save(producto);
        return producto;
    }

    @DeleteMapping(
        value = "/api/producto/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Producto deleteProducto(@PathVariable("id") long id) {
        Producto producto = repository.findById(id).orElse(null);
        if(producto == null) {
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        repository.deleteById(id);
        return producto;
    }
}

