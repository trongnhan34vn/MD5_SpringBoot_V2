package com.example.md5_ss8_baitap_1_validateformdangki.service;

import com.example.md5_ss8_baitap_1_validateformdangki.model.User;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    Iterable<User> findAll(Pageable pageable);
    void save(User user);
}
