package com.demosecurity.security.userPrincipal;


import com.demosecurity.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Lob;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPrincipal implements UserDetails {

    private Long id;
    private String name;
    private String username;
    @JsonIgnore
    private String password;
    private String email;
    private String avatar;
    private Collection<? extends GrantedAuthority> roles;

    public static UserPrincipal build(User user){
        List<GrantedAuthority> grantedAuthorities = user.getRoles().stream().map(
                role -> new SimpleGrantedAuthority(role.getName().name())
        ).collect(Collectors.toList());
        return UserPrincipal.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .avatar(user.getAvatar())
                .roles(grantedAuthorities)
                .build();
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
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        // tai khoan con han su dung hay khong?
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // tai khoan co bi block khong?
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // ma xac nhan cua tai khoan da het han chua?
        return true;
    }

    @Override
    public boolean isEnabled() {
        // tai khoan da duoc kich hoat hay chua?
        return true;
    }
}

// --> Access Security co the su dung -> interface userDetails
