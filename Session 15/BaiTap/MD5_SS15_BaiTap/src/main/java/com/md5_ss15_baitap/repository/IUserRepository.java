package com.md5_ss15_baitap.repository;

import com.md5_ss15_baitap.model.Role;
import com.md5_ss15_baitap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface IUserRepository extends JpaRepository<User, Long> {
        Boolean existsByEmail(String email);
        Optional<User> findByEmail(String email);
}
