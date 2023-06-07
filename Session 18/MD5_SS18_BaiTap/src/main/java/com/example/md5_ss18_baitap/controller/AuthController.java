package com.example.md5_ss18_baitap.controller;

import com.example.md5_ss18_baitap.dto.request.SignInForm;
import com.example.md5_ss18_baitap.dto.request.SignUpForm;
import com.example.md5_ss18_baitap.dto.response.JwtResponse;
import com.example.md5_ss18_baitap.dto.response.ResponseMessage;
import com.example.md5_ss18_baitap.model.Role;
import com.example.md5_ss18_baitap.model.RoleName;
import com.example.md5_ss18_baitap.model.User;
import com.example.md5_ss18_baitap.security.jwt.JwtProvider;
import com.example.md5_ss18_baitap.security.userPrinciple.UserPrinciple;
import com.example.md5_ss18_baitap.service.ILocationService;
import com.example.md5_ss18_baitap.service.IRoleService;
import com.example.md5_ss18_baitap.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    IUserService userService;

    @Autowired
    ILocationService locationService;

    @Autowired
    IRoleService roleService;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpForm signUpForm) {
        if(userService.existsByEmail(signUpForm.getEmail())) {
            return ResponseEntity.badRequest().body(new ResponseMessage("Email is already exist!"));
        }
        User user = new User();
        user.setEmail(signUpForm.getEmail());
        user.setPassword(passwordEncoder.encode(signUpForm.getPassword()));
        user.setLocation(locationService.findById(signUpForm.getLocationId()).orElseThrow(()-> new RuntimeException("Location Not Found")));
        Set<String> strRole =  signUpForm.getRoles();
        Set<Role> roles = new HashSet<>();
        if (strRole == null) {
            Role role = roleService.findByName(RoleName.USER).orElseThrow(()-> new RuntimeException("Role Not Found!"));
            roles.add(role);
        } else {
            strRole.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleService.findByName(RoleName.ADMIN).orElseThrow(()-> new RuntimeException("Role Not Found!"));
                        roles.add(adminRole);
                    case "pm":
                        Role pmRole = roleService.findByName(RoleName.PM).orElseThrow(()-> new RuntimeException("Role Not Found!"));
                        roles.add(pmRole);
                    case "user":
                        Role userRole = roleService.findByName(RoleName.USER).orElseThrow(()-> new RuntimeException("Role Not Found!"));
                        roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        userService.save(user);
        return ResponseEntity.ok(new ResponseMessage("Create Success!"));
    }


    @PostMapping("/signin")
    public ResponseEntity<?> login(@Valid @RequestBody SignInForm signInForm) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInForm.getEmail(), signInForm.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateJwtToken(authentication);
        UserPrinciple userDetails = (UserPrinciple) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getLocation().getName(), userDetails.getAuthorities()));
    }
}
