package com.md5_ss15_baitap.controller;

import com.md5_ss15_baitap.dto.response.ResponseMessenger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {
    @GetMapping("/home")
    public ResponseEntity<?> adminPage() {
        return new ResponseEntity<>(new ResponseMessenger("Đây là trang admin"), HttpStatus.OK);
    }
}
