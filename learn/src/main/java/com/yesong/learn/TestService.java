package com.yesong.learn;

import org.springframework.stereotype.Service;

@Service
public class TestService implements UnitTestService{
    @Override
    public String test(String test) {
        return test;
    }
}
