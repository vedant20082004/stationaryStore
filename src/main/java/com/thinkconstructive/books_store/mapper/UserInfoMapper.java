package com.thinkconstructive.books_store.mapper;

import com.thinkconstructive.books_store.Entity.UserInfo;
import com.thinkconstructive.books_store.dto.UserInfoDto;

public class UserInfoMapper {

    public static UserInfoDto toDto (UserInfo userInfo){
        return new UserInfoDto(userInfo.getUserName(),
                userInfo.getPassword(),
                userInfo.getRoles());
    }

    public static UserInfo toEntity(UserInfoDto userInfoDto){

        return new UserInfo(userInfoDto.username(),
                userInfoDto.password(),
                userInfoDto.roles());
    }
}
