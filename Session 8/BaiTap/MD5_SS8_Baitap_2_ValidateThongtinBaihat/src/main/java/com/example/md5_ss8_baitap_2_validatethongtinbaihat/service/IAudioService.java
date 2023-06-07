package com.example.md5_ss8_baitap_2_validatethongtinbaihat.service;

import com.example.md5_ss8_baitap_2_validatethongtinbaihat.model.Audio;

public interface IAudioService {
    Iterable<Audio> findAll();
    void save(Audio audio);
}
