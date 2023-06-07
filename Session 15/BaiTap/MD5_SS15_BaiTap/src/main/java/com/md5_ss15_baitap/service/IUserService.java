package com.md5_ss15_baitap.service;

import com.md5_ss15_baitap.model.User;

import java.util.Optional;

public interface IUserService {
    Boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
    User save(User user);
}
