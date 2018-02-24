package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 墨殇
 * @description:
 * @Date : 2018/2/24.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserJPA userJPA;

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public List<UserEntity> list(){
        return userJPA.findAll();
    }
    @RequestMapping(value = "save",method = RequestMethod.GET)
    public UserEntity save(UserEntity userEntity){
        return userJPA.save(userEntity);
    }
    @RequestMapping(value = "delete",method = RequestMethod.GET)
    public List<UserEntity> delete(Long  id){
         userJPA.delete(id);
         return userJPA.findAll();
    }
}
