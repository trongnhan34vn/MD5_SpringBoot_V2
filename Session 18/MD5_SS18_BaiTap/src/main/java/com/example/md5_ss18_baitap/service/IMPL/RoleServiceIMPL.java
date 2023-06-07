package com.example.md5_ss18_baitap.service.IMPL;

import com.example.md5_ss18_baitap.model.Role;
import com.example.md5_ss18_baitap.model.RoleName;
import com.example.md5_ss18_baitap.repository.IRoleRepository;
import com.example.md5_ss18_baitap.service.IRoleService;
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
