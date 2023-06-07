package com.md5_ss15_baitap.service;

import com.md5_ss15_baitap.model.Role;
import com.md5_ss15_baitap.model.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}
