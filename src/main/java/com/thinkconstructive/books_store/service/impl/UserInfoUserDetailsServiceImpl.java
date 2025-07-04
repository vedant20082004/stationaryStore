package com.thinkconstructive.books_store.service.impl;

import com.thinkconstructive.books_store.Entity.UserInfo;
import com.thinkconstructive.books_store.mapper.UserInfoUserDetailMapper;
import com.thinkconstructive.books_store.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserInfo> userInfo = userInfoRepository.findByUserName(username);



        return userInfo.map(UserInfoUserDetailMapper::new)
                .orElseThrow(() -> new UsernameNotFoundException("User " +username+" Not Found" ));
    }
}
