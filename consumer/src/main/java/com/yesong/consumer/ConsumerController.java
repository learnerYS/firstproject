package com.yesong.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    private ISend isend;

    @RequestMapping("test")
    @HystrixCommand(fallbackMethod = "fallback")
    public String test() {
        String send = isend.send();
        return send;
    }
    public String fallback(){
        return "网络异常";
    }

}
