package com.md5_ss17_baith_1_simpleapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JV11Controller {
    @GetMapping("/jv11")
    public String jv11(){
        return "jv11";
    }
}
