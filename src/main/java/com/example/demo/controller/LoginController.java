package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 墨殇
 * @description:
 * @Date : 2018/2/24.
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserJPA userJPA;

    @RequestMapping("/login")
    public String login(UserEntity userEntity, HttpServletRequest request){
        boolean flag=true;
        String result="登陆成功";
        //根据用户名查询用户是否存在
        UserEntity userEntity1=userJPA.findOne(new Specification<UserEntity>() {
            @Override
            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                criteriaQuery.where(criteriaBuilder.equal(root.get("name"), userEntity.getName()));
                return null;
            }

        });
        //用户不存在
        if (userEntity1==null){
            result="用户不存在，登陆失败";
        }
        //密码错误
        else if(!userEntity1.getPassword().equals(userEntity.getPassword())){

            result="密码错误，登陆失败！";
        }
        if (flag){
            //将用户写入到session
            request.getSession().setAttribute("session_user",userEntity1);
        }
        return  result;
    }
}
