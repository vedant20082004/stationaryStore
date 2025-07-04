package com.thinkconstructive.books_store.repository;

import com.thinkconstructive.books_store.Entity.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
// import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserInfoRepository extends MongoRepository<UserInfo, String> {

    Optional<UserInfo> findByUserName(String username);



}
