package com.example.md5_ss15_baith_jwt.service;

import com.example.md5_ss15_baith_jwt.model.User;

import java.util.Optional;

public interface IUserService {
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Optional<User> findByUsername(String username);
    User save(User user);

}
