package com.servicebar.backend.controllers;

import com.servicebar.backend.models.*;
import com.servicebar.backend.repositories.ClienteRepository;
import com.servicebar.backend.security.jwt.JwtUtils;
import com.servicebar.backend.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.servicebar.backend.repositories.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@EnableAutoConfiguration
public class UsuarioController {
    private final UsuarioRepository repository;
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @GetMapping(
        value = "/api/usuario",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Iterable<Usuario> getUsuarios() {
        return repository.findAll();
    }

    @GetMapping(
        value = "/api/usuario/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Usuario getUsuarioById(@PathVariable("id") long id) {
        Usuario usuario = repository.findById(id).orElse(null);
        if(usuario == null) {
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        return usuario;
    }

    @PostMapping(
        value = "/api/usuario",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Usuario postUsuario(@RequestBody Usuario usuario) {
        var role = new Role();
        role.setId(1);
        role.setName(ERole.ROLE_USER);
        usuario.addRole(role);
        var encoder = new BCryptPasswordEncoder();
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        repository.save(usuario);
        return usuario;
    }

    @PostMapping("/api/usuario/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        Cliente cliente = clienteRepository.findById(userDetails.getIdCliente()).orElse(null);


        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(new InfoUsuarioRespuesta(userDetails.getId(),
                        userDetails.getEmail(),
                        roles,
                        userDetails.getIdCliente(),
                        cliente != null ? cliente.getNombre() : ""
                        ));
    }

    @PostMapping("/api/usuario/signout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MensajeRespuesta("Deslogueado correctamente."));
    }

    @PutMapping(
        value = "/api/usuario",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Usuario putUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioAct = repository.findById(usuario.getIdUsuario()).orElse(null);
        if(usuarioAct == null) {
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        repository.save(usuario);
        return usuario;
    }

    @DeleteMapping(
        value = "/api/usuario/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Usuario deleteUsuario(@PathVariable("id") long id) {
        Usuario usuario = repository.findById(id).orElse(null);
        if(usuario == null) {
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        repository.deleteById(id);
        return usuario;
    }
}
