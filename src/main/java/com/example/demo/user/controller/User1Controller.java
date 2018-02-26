package com.example.demo.user.controller;

import com.example.demo.user.bean.UserBean;
import com.example.demo.user.jpa.User1JPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 墨殇
 * @description:
 * @Date : 2018/2/26.
 */
@RestController
@RequestMapping(value = "/user1")
public class User1Controller {

    @Autowired
    private User1JPA user1JPA;

    /**
     * 查询所有用户列表
     * @return
     */
    @RequestMapping(value = "/list")
    public List<UserBean> list(){
        return user1JPA.findAll();
    }
}