package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author 墨殇
 * @description:
 * @Date : 2018/2/26.
 */
@Configuration
public class StaticResourcesConfiguration extends WebMvcConfigurerAdapter {
    //自定义静态资源文件路径

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/demo/resources/**").addResourceLocations("classpath:/static/");

    }
}
