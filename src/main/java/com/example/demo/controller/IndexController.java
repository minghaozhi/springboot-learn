package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.util.LoggerUtils;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 墨殇
 * @description:
 * @Date : 2018/2/24.
 */
@RestController
@RequestMapping("/index")
public class IndexController {
    /**
     * 初始化登录页面
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    /**
     * 初始化登录页面
     */
    @RequestMapping(value = "/login1",method = RequestMethod.GET)
    public JSONObject login1(HttpServletRequest request,String name)throws Exception{
        JSONObject object=new JSONObject();
        object.put("msg","用户:"+name+"登陆成功");
        request.setAttribute(LoggerUtils.LOGGER_RETURN,object);
        return object;
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){

        return " get index";
    }
}
