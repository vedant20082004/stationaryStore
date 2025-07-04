package com.thinkconstructive.books_store.controller;

import com.thinkconstructive.books_store.dto.UserInfoDto;
import com.thinkconstructive.books_store.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-info")

public class UserInfoContoller {

    @Autowired
    UserInfoService userInfoService;

    @PostMapping("/register")
    public ResponseEntity<String> createUserInfo(@RequestBody UserInfoDto userInfoDto){
        UserInfoDto userInfoDto1 = userInfoService.createUser(userInfoDto);
        return new ResponseEntity<>("User" + userInfoDto1.username() + "is Created", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> getUserInfo(@RequestBody UserInfoDto userInfoDto) {
        try {
            String token = userInfoService.getUserInfo(userInfoDto);
            if ("Failure".equals(token)) {
                return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
            }
            return new ResponseEntity<>(token, HttpStatus.OK);
        } catch (org.springframework.security.core.AuthenticationException ex) {
            return new ResponseEntity<>("Authentication failed: " + ex.getMessage(), HttpStatus.UNAUTHORIZED);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
