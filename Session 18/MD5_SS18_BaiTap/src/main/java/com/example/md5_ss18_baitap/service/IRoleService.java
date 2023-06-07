package com.example.md5_ss18_baitap.service;

import com.example.md5_ss18_baitap.model.Role;
import com.example.md5_ss18_baitap.model.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}
