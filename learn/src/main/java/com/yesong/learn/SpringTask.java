package com.yesong.learn;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SpringTask {
    @Scheduled(cron = "*/5 * * * * ?")
    @Async("ysthreadpool")
    public void test(){
        System.out.println("spring定时器"+new Date()+"threadname:"+Thread.currentThread().getName());
    }
}
