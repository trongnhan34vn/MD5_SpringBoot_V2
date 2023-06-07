package com.example.md5_ss18_baitap.service;

import com.example.md5_ss18_baitap.model.Location;

import java.util.Optional;

public interface ILocationService {
    Optional<Location> findById(Long id);
}
