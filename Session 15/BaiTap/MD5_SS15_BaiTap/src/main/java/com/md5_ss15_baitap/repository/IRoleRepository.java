package com.md5_ss15_baitap.repository;

import com.md5_ss15_baitap.model.Role;
import com.md5_ss15_baitap.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
