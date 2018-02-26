package com.example.demo.controller;

import com.example.demo.entity.WiselyMessage;
import com.example.demo.entity.WiselyResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @author 墨殇
 * @description:
 * @Date : 2018/2/26.
 */
@Controller
public class WsController {
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message) throws Exception{
        //等待3秒返回消息内容
        Thread.sleep(3000);
        return  new WiselyResponse("欢迎使用websocket:"+ message.getName());
    }
}