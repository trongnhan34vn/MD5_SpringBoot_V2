package com.md5_ss15_baitap.security.userPrinciple;

import com.md5_ss15_baitap.model.User;
import com.md5_ss15_baitap.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    IUserRepository userRepository;

    /**
     * Build UserDetails từ UserPrinciple
     * @param username the username identifying the user whose data is required.
     * @return userDetails
     * @throws UsernameNotFoundException
     */

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Email Not Found"));
        return UserPrinciple.build(user);
    }
}
