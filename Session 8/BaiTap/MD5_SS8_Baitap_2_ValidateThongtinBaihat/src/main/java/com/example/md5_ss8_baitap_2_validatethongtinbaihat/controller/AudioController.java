package com.example.md5_ss8_baitap_2_validatethongtinbaihat.controller;

import com.example.md5_ss8_baitap_2_validatethongtinbaihat.model.Audio;
import com.example.md5_ss8_baitap_2_validatethongtinbaihat.service.AudioServiceIMPL;
import com.example.md5_ss8_baitap_2_validatethongtinbaihat.service.IAudioService;
import com.example.md5_ss8_baitap_2_validatethongtinbaihat.validate.AudioValidate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class AudioController {
    IAudioService audioService = new AudioServiceIMPL();
    @GetMapping
    public String show(Model model) {
        model.addAttribute("audio", new Audio());
        return "/index";
    }

    @PostMapping("/create")
    public String createAudio(@Valid @ModelAttribute ("audio") Audio audio, BindingResult bindingResult, Model model) {
        new AudioValidate().checkValidate(audio, bindingResult);
        System.out.println(bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/index";
        }
        audioService.save(audio);
        return "/result";
    }
}
