package com.example.demo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 墨殇
 * @description:
 * @Date : 2018/2/27.
 */
@Component
public class PrinkTest {

    /**
     * 每小时的10分执行此方法
     */
    @Scheduled(cron = "0 10 *********")
    public void cron(){
        System.out.println("执行测试的时间："+new Date(System.currentTimeMillis()));
    }
}
