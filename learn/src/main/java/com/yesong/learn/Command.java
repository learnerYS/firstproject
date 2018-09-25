package com.yesong.learn;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Command implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {
        System.out.println("hello world");
    }
}
