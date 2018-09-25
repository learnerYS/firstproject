package com.yesong.learn;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;

@Swagger
@RestController
@Api("test")
@RequestMapping("test")
public class TestControllerr {
    private static final Logger log = Logger.getLogger(TestControllerr.class);
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private ISpringBoot springBoot;
    @GetMapping(value = "test/{name}")
    @ApiOperation("测试")
    public String test(@PathVariable String name){
        TestService bean = applicationContext.getBean(TestService.class);
        String te = bean.test("te");
        return te;
    }

    @GetMapping(value = "asyn")
    public void test() throws InterruptedException {
        for (int i = 0 ; i<10 ;i++){
                springBoot.test(i);
        }
    }

    @PostMapping(value = "log")
    public void log() throws ServerException {
        log.info("日志打印");
        throw new ServerException("错误日志");
    }
}
