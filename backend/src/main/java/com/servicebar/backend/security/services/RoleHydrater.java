package com.servicebar.backend.security.services;

import com.servicebar.backend.models.Role;
import com.servicebar.backend.models.RoleRef;
import com.servicebar.backend.models.Usuario;
import com.servicebar.backend.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component("roleHydrater")
public class RoleHydrater {
    @Autowired
    private RoleRepository roleRepository;

    public Set<Role> getHydratedRoles(Usuario usuario) {
        var result = new HashSet<Role>();
        for(RoleRef ref : usuario.getRoles()) {
            var role = roleRepository.findById(ref.getRoleId());
            role.ifPresent(result::add);
        }

        return result;
    }
}
