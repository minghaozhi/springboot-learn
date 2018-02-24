package com.example.demo;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author 墨殇
 * @description:
 * @Date : 2018/2/24.
 */
@Configuration
public class FastJsonConfiguration extends WebMvcConfigurerAdapter {
    /**
     * 修改自定义消息转换器
     */
     @Override
     public  void  configureMessageConverters(List<HttpMessageConverter<?>> converters){
         //调用父类的配置
         super.configureMessageConverters(converters);
         //创建fastJson消息转换器
         FastJsonHttpMessageConverter fastJsonHttpMessageConverter=new FastJsonHttpMessageConverter();
         //创建配置类
         FastJsonConfig config=new FastJsonConfig();
         //修改配置返回内容的过滤
         config.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect,
                 SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty);
         fastJsonHttpMessageConverter.setFastJsonConfig(config);
         //将fastJson添加到视图消息转换列表内
         converters.add(fastJsonHttpMessageConverter);
     }
}
