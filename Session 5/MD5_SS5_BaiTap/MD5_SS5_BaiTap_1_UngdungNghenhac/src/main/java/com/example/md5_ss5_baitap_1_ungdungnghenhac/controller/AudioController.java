package com.example.md5_ss5_baitap_1_ungdungnghenhac.controller;

import com.example.md5_ss5_baitap_1_ungdungnghenhac.model.Audio;
import com.example.md5_ss5_baitap_1_ungdungnghenhac.service.AudioServiceIMPL;
import com.example.md5_ss5_baitap_1_ungdungnghenhac.service.IAudioService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/")
@PropertySource("classpath:file_upload.properties")
public class AudioController {
    @Value("${file-upload}")
    private String fileUpload;
    IAudioService audioService = new AudioServiceIMPL();
    @GetMapping
    public String show(Model model) {
        model.addAttribute("audioList", audioService.findAll());
        return "show";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("audio", new Audio());
        return "create";
    }

    @PostMapping("/create")
    public String createAudio(@ModelAttribute ("audio") Audio newAudio, @RequestParam ("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        newAudio.setUrl(fileName);
        audioService.save(newAudio);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String showFormUpdate(Model model, @RequestParam int id) {
        model.addAttribute("audio", audioService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String updateAudio(@ModelAttribute Audio audio) {
        audioService.save(audio);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        audioService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam ("id") int id ,Model model) {
        model.addAttribute("audio", audioService.findById(id));
        return "detail";
    }
}
