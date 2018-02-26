package com.example.demo.service;

import com.example.demo.entity.UsersEntity;
import com.example.demo.jpa.UsersJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author 墨殇
 * @description:
 * @Date : 2018/2/26.
 */
public class UsersService implements UserDetailsService{
    @Autowired
    private UsersJPA usersJPA;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity users=usersJPA.findByUsername(username);
        if (users==null){
           throw  new   UsernameNotFoundException("未查詢到用戶："+username+"信息");
        }

        return users;
    }
}
