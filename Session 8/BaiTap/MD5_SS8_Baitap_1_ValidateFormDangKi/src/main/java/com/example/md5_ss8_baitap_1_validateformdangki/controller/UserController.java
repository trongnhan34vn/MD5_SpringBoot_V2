package com.example.md5_ss8_baitap_1_validateformdangki.controller;

import com.example.md5_ss8_baitap_1_validateformdangki.model.User;
import com.example.md5_ss8_baitap_1_validateformdangki.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping
    public String show(Model model) {
        model.addAttribute("user", new User());
        return "/index";
    }

    @PostMapping("/register")
    public String register(@Validated @ModelAttribute ("user") User user, BindingResult bindingResult, Model model) {
        if(bindingResult.hasFieldErrors()) {
            return "/index";
        }
        userService.save(user);
        model.addAttribute("message", "Register Success!");
        return "/success";
    }
}
