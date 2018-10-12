package com.yesong.fileclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FileclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileclientApplication.class, args);
    }
}
