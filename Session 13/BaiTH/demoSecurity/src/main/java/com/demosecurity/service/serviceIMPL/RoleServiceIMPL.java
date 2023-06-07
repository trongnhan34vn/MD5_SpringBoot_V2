package com.demosecurity.service.serviceIMPL;

import com.demosecurity.model.Role;
import com.demosecurity.model.RoleName;
import com.demosecurity.repository.IRoleRepository;
import com.demosecurity.service.IRoleService;
import com.demosecurity.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceIMPL implements IRoleService {

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
