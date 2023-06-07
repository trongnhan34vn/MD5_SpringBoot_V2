package com.example.md5_ss8_baitap_1_validateformdangki.repository;

import com.example.md5_ss8_baitap_1_validateformdangki.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<User, Long> {
    Page<User> findAll (Pageable pageable);
}
