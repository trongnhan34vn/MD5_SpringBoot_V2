package com.md5_ss15_baitap.controller;

import com.md5_ss15_baitap.dto.request.SignInForm;
import com.md5_ss15_baitap.dto.request.SignUpForm;
import com.md5_ss15_baitap.dto.response.JwtResponse;
import com.md5_ss15_baitap.dto.response.ResponseMessenger;
import com.md5_ss15_baitap.model.Role;
import com.md5_ss15_baitap.model.RoleName;
import com.md5_ss15_baitap.model.User;
import com.md5_ss15_baitap.security.jwt.JwtProvider;
import com.md5_ss15_baitap.security.userPrinciple.UserPrinciple;
import com.md5_ss15_baitap.service.IMPL.RoleServiceIMPL;
import com.md5_ss15_baitap.service.IMPL.UserServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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

@RequestMapping("/api/auth")
@RestController
public class AuthController {
    @Autowired
    UserServiceIMPL userService;
    @Autowired
    RoleServiceIMPL roleService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;
    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpForm signUpForm) {
        if (userService.existsByEmail(signUpForm.getEmail())) {
            return new ResponseEntity<>(new ResponseMessenger("Email is existed!"), HttpStatus.OK);
        }
        User user = new User(signUpForm.getEmail(), passwordEncoder.encode(signUpForm.getPassword()));
        // converse Role từ String role sang kiểu Role
        Set<String> strRoles = signUpForm.getRoles();
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role -> {
            switch (role) {
                case "admin":
                    Role adminRole = roleService.findByName(RoleName.ADMIN).orElseThrow(() ->
                        new RuntimeException("Role Not Found")
                    );
                    roles.add(adminRole);
                    break;
                case "pm":
                    Role pmRole = roleService.findByName(RoleName.PM).orElseThrow(() ->
                            new RuntimeException("Role Not Found")
                    );
                    roles.add(pmRole);
                    break;
                default:
                    Role userRole = roleService.findByName(RoleName.USER).orElseThrow(() ->
                            new RuntimeException("Role Not Found")
                    );
                    roles.add(userRole);
            }
        });
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity<>(new ResponseMessenger("Create Success!"), HttpStatus.OK);
    }


    @PostMapping("/signin")
    public ResponseEntity<?> login(@Valid @RequestBody SignInForm signInForm) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInForm.getEmail(),signInForm.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.createToken(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, token)
                .body(new JwtResponse(token, userPrinciple.getEmail(), userPrinciple.getAuthorities()));
    }
}
