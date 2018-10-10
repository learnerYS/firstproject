package com.yesong.client;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Test {
    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String test() throws Exception {
        //Thread.sleep(50000L);
        return "hello";
    }
}
