package com.md5_ss15_baitap.config;

import com.md5_ss15_baitap.model.Role;
import com.md5_ss15_baitap.model.RoleName;
import com.md5_ss15_baitap.repository.IRoleRepository;
import com.md5_ss15_baitap.security.jwt.JwtEntryPoint;
import com.md5_ss15_baitap.security.jwt.JwtTokenFilter;
import com.md5_ss15_baitap.security.userPrinciple.UserDetailService;
import com.md5_ss15_baitap.security.userPrinciple.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailService userDetailService;
    @Autowired
    private JwtEntryPoint jwtEntryPoint;

    @Bean
    public JwtTokenFilter jwtTokenFilter() {
        return new JwtTokenFilter();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/api/auth/**", "/login").permitAll()
//
//                .antMatchers("/").hasAnyAuthority("USER")
//                .antMatchers("/admin/**").access("hasAnyAuthority('ADMIN')")

//                .and()
//                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)

//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

//        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        // Enable CORS and disable CSRF
        http = http.cors().and().csrf().disable();

        // Set session management to stateless
//        http = http
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and();
        // Set permissions on endpoints
        http.authorizeRequests()
                // Our public endpoints
                .antMatchers("/api/auth/**").permitAll()
                // Our private endpoints
                .antMatchers("/api/admin/**").hasAuthority("ADMIN")
                .antMatchers("/").hasAuthority("USER")

                .anyRequest().authenticated();
        http.addFilterBefore(
                jwtTokenFilter(),
                UsernamePasswordAuthenticationFilter.class
        );
    }
}
