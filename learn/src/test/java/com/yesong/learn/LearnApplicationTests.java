package com.yesong.learn;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnApplicationTests {
    @Autowired
    private UnitTestService unitTestService;
    @Test
    public void contextLoads() {
        String yesong = unitTestService.test("yesong");
        Assert.assertEquals("yesong",yesong);
    }

}
