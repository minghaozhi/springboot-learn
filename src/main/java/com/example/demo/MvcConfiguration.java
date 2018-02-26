package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author 墨殇
 * @description:
 * @Date : 2018/2/26.
 */
@Configuration
public class MvcConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
       // registry.addViewController("/login").setViewName("login");
        registry.addViewController("/websocket").setViewName("/websocket");
    }
}
