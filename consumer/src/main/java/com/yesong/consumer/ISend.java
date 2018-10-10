package com.yesong.consumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("eureka-client")
public interface ISend {
    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String send();
}
