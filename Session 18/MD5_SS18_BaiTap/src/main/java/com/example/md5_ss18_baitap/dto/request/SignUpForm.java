package com.example.md5_ss18_baitap.dto.request;

import com.example.md5_ss18_baitap.model.Location;
import java.util.Set;

public class SignUpForm {
    private Long id;
    private String email;

    private String password;

    private Set<String> roles;

    private Long locationId;

    public SignUpForm(Long id, String email, String password, Set<String> roles, Long locationId) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.locationId = locationId;
    }

    public SignUpForm() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }
}
