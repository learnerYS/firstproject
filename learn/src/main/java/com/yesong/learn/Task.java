package com.yesong.learn;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("task")
public class Task {
    private static final Logger log = Logger.getLogger(Task.class);
    @RequestMapping("time")
    public void time(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.info("定时器"+new Date());
            }
        }, 1000);
    }

    @RequestMapping("time2")
    public void test2(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                log.info("定时器2"+new Date());
            }
        },1, TimeUnit.SECONDS);
        log.info("ScheduledExecutorService定时任务启动：" + new Date());
    }
}
