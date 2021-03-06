package com.example.demo;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;

/**
 * @author 墨殇
 * @description:
 * @Date : 2018/2/26.
 */
@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport{
    /**
     * 采用RedisCacheManager做缓存管理
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate){
        return  new RedisCacheManager(redisTemplate);
    }
    /**
     * 自定义生成key的规则
     */
    @Override
    public  KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                //格式化缓存key字符串
                StringBuilder sb = new StringBuilder();
                //追加类名
                sb.append(o.getClass().getName());
                //追加方法名
                sb.append(method.getName());
                //遍历参数并且追加
                for (Object obj : objects) {
                    sb.append(obj.toString());
                }
                System.out.println("调用Redis缓存Key : " + sb.toString());
                return sb.toString();
            }
        };
    }
}
