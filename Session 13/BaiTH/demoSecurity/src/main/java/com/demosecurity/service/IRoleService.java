package com.demosecurity.service;

import com.demosecurity.model.Role;
import com.demosecurity.model.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}
