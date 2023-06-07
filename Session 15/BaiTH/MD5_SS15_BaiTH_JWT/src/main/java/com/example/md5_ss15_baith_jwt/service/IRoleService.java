package com.example.md5_ss15_baith_jwt.service;

import com.example.md5_ss15_baith_jwt.model.Role;
import com.example.md5_ss15_baith_jwt.model.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}
