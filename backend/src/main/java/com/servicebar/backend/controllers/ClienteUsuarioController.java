package com.servicebar.backend.controllers;

import com.servicebar.backend.models.*;
import com.servicebar.backend.repositories.ClienteRepository;
import com.servicebar.backend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@EnableAutoConfiguration
public class ClienteUsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping(
            value = "/api/usuario-cliente",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ClienteUsuario post(@RequestBody ClienteUsuario usuarioCliente) {
        var cliente = new Cliente();
        cliente.setNombre(usuarioCliente.getNombre());
        cliente.setApellido(usuarioCliente.getApellido());
        cliente.setTelefono(usuarioCliente.getTelefono());
        cliente.setDni(usuarioCliente.getDni());

        clienteRepository.save(cliente);

        var usuario = new Usuario();
        usuario.setEmail(usuarioCliente.getEmail());
        usuario.setIdCliente(cliente.getIdCliente());
        var role = new Role();
        role.setId(1);
        role.setName(ERole.ROLE_USER);
        usuario.addRole(role);
        var encoder = new BCryptPasswordEncoder();
        usuario.setPassword(encoder.encode(usuarioCliente.getPassword()));
        usuarioRepository.save(usuario);

        return usuarioCliente;
    }
}
