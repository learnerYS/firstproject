package com.yesong.learn;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class SpringbootAysn implements ISpringBoot{
    private static final Logger log = Logger.getLogger(SpringbootAysn.class);

    @Override
    @Async
    public void test(int i) throws InterruptedException {
        log.info("我是线程"+i);
        if(i == 0 || i==1 || i==2 || i==3 || i==4){
            Thread.sleep(10000);
        }
        log.info(Thread.currentThread().getName());

    }

}
