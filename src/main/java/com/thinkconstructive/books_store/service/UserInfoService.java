package com.thinkconstructive.books_store.service;

import com.thinkconstructive.books_store.dto.UserInfoDto;

public interface UserInfoService
{
    public UserInfoDto createUser(UserInfoDto userInfoDto);

    public String getUserInfo(UserInfoDto userInfoDto);
}
