package com.example.md5_ss18_baitap.repository;

import com.example.md5_ss18_baitap.model.Role;
import com.example.md5_ss18_baitap.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
