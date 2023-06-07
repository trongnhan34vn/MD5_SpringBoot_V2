package com.example.md5_ss12_baith_2_phonemanage.repository;

import com.example.md5_ss12_baith_2_phonemanage.model.SmartPhone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartPhoneRepository extends CrudRepository<SmartPhone, Long> {
    Iterable<SmartPhone> findAllByProducerContaining(String producer);
}
