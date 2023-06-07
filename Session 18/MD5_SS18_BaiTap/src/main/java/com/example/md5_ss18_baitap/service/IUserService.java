package com.example.md5_ss18_baitap.service;

import com.example.md5_ss18_baitap.model.User;

import java.util.Optional;

public interface IUserService {
    Boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);

    User save(User user);
}
