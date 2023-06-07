package com.example.md5_ss12_baith_2_phonemanage.service;

import com.example.md5_ss12_baith_2_phonemanage.model.SmartPhone;

import java.util.Optional;

public interface ISmartPhoneService {
    Iterable<SmartPhone> findAllByProducerContaining(String producer);
    Iterable<SmartPhone> findAll();
    Optional<SmartPhone> findById(Long id);
    void deleteById(Long id);
    SmartPhone save(SmartPhone smartPhone);

}
