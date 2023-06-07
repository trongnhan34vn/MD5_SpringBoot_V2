package com.example.md5_ss8_baitap_2_validatethongtinbaihat.service;

import com.example.md5_ss8_baitap_2_validatethongtinbaihat.model.Audio;
import com.example.md5_ss8_baitap_2_validatethongtinbaihat.repository.IAudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AudioServiceIMPL implements IAudioService{
    @Autowired
    IAudioRepository audioRepository;
    @Override
    public Iterable<Audio> findAll() {
        return audioRepository.findAll();
    }

    @Override
    public void save(Audio audio) {
        audioRepository.save(audio);
    }
}
