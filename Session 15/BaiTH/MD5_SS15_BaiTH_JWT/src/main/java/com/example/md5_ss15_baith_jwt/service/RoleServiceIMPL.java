package com.example.md5_ss15_baith_jwt.service;

import com.example.md5_ss15_baith_jwt.model.Role;
import com.example.md5_ss15_baith_jwt.model.RoleName;
import com.example.md5_ss15_baith_jwt.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RoleServiceIMPL implements IRoleService{
    @Autowired
    IRoleRepository roleRepository;
    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }

}
