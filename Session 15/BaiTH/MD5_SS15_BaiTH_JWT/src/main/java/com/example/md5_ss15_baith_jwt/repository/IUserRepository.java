package com.example.md5_ss15_baith_jwt.repository;

import com.example.md5_ss15_baith_jwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
    Boolean existsByUsername(String username); //Check username không trùng lặp
    Boolean existsByEmail(String email); //Check email không trùng lặp
    Optional<User> findByUsername(String username); //Tìm kiếm username có tồn tại trong DB không?
}

