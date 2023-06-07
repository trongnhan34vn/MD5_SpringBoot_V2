package com.example.md5_ss8_baith_2_customvalidate.controller;

import com.example.md5_ss8_baith_2_customvalidate.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PhoneController {

    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("phoneNumber", new PhoneNumber());
        return "/index";
    }

    @PostMapping("/")
    public String checkValidation (@Valid @ModelAttribute("phoneNumber")PhoneNumber phoneNumber, BindingResult bindingResult, Model model){
        System.out.println("binding result ------> " + bindingResult);
        new PhoneNumber().validate(phoneNumber, bindingResult);

        if (bindingResult.hasFieldErrors()){
            return "/index";
        }
        else {
            model.addAttribute("phoneNumber", phoneNumber);
            return "/result";
        }
    }


}
