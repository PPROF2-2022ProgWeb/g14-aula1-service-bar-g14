package com.servicebar.backend.repositories;

import com.servicebar.backend.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {
}
