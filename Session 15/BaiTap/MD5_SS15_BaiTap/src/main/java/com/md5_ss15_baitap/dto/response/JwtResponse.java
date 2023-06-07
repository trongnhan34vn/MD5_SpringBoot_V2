package com.md5_ss15_baitap.dto.response;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtResponse {
    private Long Id;
    private String token;
    private String type = "Bearer";
    private String email;
    private Collection<? extends GrantedAuthority> roles;

    public JwtResponse(Long id, String token, String type, String email, Collection<? extends GrantedAuthority> roles) {
        Id = id;
        this.token = token;
        this.type = type;
        this.email = email;
        this.roles = roles;
    }

    public JwtResponse() {
    }

    public JwtResponse(String token, String email, Collection<? extends GrantedAuthority> roles) {
        this.token = token;
        this.email = email;
        this.roles = roles;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }
}
