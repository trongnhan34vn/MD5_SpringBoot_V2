package com.example.md5_ss8_baitap_1_validateformdangki.service;

import com.example.md5_ss8_baitap_1_validateformdangki.model.User;
import com.example.md5_ss8_baitap_1_validateformdangki.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIMPL implements IUserService{
    @Autowired
    IUserRepository userRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
