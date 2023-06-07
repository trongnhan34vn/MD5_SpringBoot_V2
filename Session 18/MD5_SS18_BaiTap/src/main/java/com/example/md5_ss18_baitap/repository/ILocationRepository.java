package com.example.md5_ss18_baitap.repository;

import com.example.md5_ss18_baitap.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocationRepository extends JpaRepository<Location, Long> {
}
