package com.example.demo.servlet;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 墨殇
 * @description:
 * @Date : 2018/2/26.
 */
@Configuration
@ServletComponentScan
public class ServletConfiguration {

//    @Bean
//    public ServletRegistrationBean servletRegistrationBean(){
//        return  new ServletRegistrationBean(new TestServlet(),"/test");
//    }
}
