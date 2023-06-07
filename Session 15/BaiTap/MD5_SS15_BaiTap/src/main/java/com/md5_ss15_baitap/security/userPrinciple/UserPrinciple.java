package com.md5_ss15_baitap.security.userPrinciple;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.md5_ss15_baitap.model.Role;
import com.md5_ss15_baitap.model.User;
import org.hibernate.annotations.NaturalId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserPrinciple implements UserDetails {

    private Long id;

    private String email;
    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> roles;

    public UserPrinciple(Long id, String email, String password, Collection<? extends GrantedAuthority> roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.roles = roles;
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

    /**
     * Lấy ra tất cả thông tin user hiện tại để tạo chứng thực người dùng cùng với authorities(phân quyền)
     * @param user
     * @return userPrinciple (chứng thực người dùng)
     */
    public static UserPrinciple build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
        return new UserPrinciple(user.getId(), user.getEmail(), user.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
