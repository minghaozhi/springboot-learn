package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 墨殇
 * @description:
 * @Date : 2018/2/26.
 */
@Service
@CacheConfig(cacheNames = "user")
public class UserService {
    @Autowired
    private UserJPA userJPA;

    @Cacheable
    public List<UserEntity> list(){
        return  userJPA.findAll();
    }
}
