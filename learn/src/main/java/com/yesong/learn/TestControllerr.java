package com.yesong.learn;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.ArrayList;

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

    @RequestMapping(value = "info",method = RequestMethod.POST)
    public CommonResponse<Address> info(@RequestBody String id){
        CommonResponse<Address> addressCommonResponse = new CommonResponse<>();
        if(id.equals("info")){
            Address address = new Address();
            address.setName("yesong");
            address.setCity("hangzhou");
            addressCommonResponse.setInfoResponse(address);
        }else if(id.equals("list")){
            ArrayList<Address> addresses = new ArrayList<>();
            Address address = new Address();
            address.setName("123");
            address.setCity("456");
            addresses.add(address);
            Address address1 = new Address();
            address1.setName("123");
            address1.setCity("456");
            addresses.add(address1);
            addressCommonResponse.setListResponse(addresses);
        }
        return addressCommonResponse;
    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    public CommonResponse<User> list(@RequestBody String id){
        CommonResponse<User> addressCommonResponse = new CommonResponse<>();
        if(id.equals("info")){
            User address = new User();
            address.setName("yesong");
            address.setAddress("treggsfgd");
            addressCommonResponse.setInfoResponse(address);
        }else if(id.equals("list")){
            ArrayList<User> addresses = new ArrayList<>();
            User address = new User();
            address.setName("123");
            address.setAddress("456");
            addresses.add(address);
            User address1 = new User();
            address1.setName("234");
            address1.setAddress("567");
            addresses.add(address1);
            addressCommonResponse.setListResponse(addresses);
        }
        return addressCommonResponse;
    }
}
