package com.example.POCBankService.service;

import com.example.POCBankService.entity.UserInfo;
import com.example.POCBankService.repository.UserInfoRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserInfoRepository userInfoRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private final Map<String, UserDetails> users = new HashMap<>();

    public CustomUserDetailsService(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoRepository.findOneByUserId(username).orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return User.builder()
                .username(userInfo.getUserId())
                .password(userInfo.getPassword())
                .roles(userInfo.getRole().name())
                .build();
    }
}


