package com.example.md5_ss5_baitap_1_ungdungnghenhac.service;

import com.example.md5_ss5_baitap_1_ungdungnghenhac.model.Audio;

import java.util.List;

public interface IAudioService {
    List<Audio> findAll();
    void save(Audio audio);
    Audio findById(int id);
    void delete(int id);
}
