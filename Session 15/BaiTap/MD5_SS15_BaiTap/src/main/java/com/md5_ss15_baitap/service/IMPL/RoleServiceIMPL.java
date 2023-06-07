package com.md5_ss15_baitap.service.IMPL;

import com.md5_ss15_baitap.model.Role;
import com.md5_ss15_baitap.model.RoleName;
import com.md5_ss15_baitap.repository.IRoleRepository;
import com.md5_ss15_baitap.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceIMPL implements IRoleService {
    @Autowired
    IRoleRepository roleRepository;

    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
