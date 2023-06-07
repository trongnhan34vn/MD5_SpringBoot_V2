package com.example.md5_ss8_baitap_2_validatethongtinbaihat.repository;

import com.example.md5_ss8_baitap_2_validatethongtinbaihat.model.Audio;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAudioRepository extends PagingAndSortingRepository<Audio, Long> {
}
