package com.example.md5_ss18_baitap.service.IMPL;

import com.example.md5_ss18_baitap.model.User;
import com.example.md5_ss18_baitap.repository.IUserRepository;
import com.example.md5_ss18_baitap.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceIMPL implements IUserService {
    @Autowired
    IUserRepository userRepository;
    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
