package com.servicebar.backend.security.services;

import com.servicebar.backend.models.Usuario;
import com.servicebar.backend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UsuarioRepository usuarioRepositorio;

    @Autowired
    private RoleHydrater roleHydrater;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByEmail(username);

        if(usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con el email " + username);
        }

        var roles = roleHydrater.getHydratedRoles(usuario);
        return UserDetailsImpl.build(usuario, roles);
    }
}
