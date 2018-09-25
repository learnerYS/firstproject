package com.yesong.learn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class ThreadPoolConfig {
    @Bean(name = "ysthreadpool")
    public ThreadPoolTaskExecutor create(){
        ThreadPoolTaskExecutor poolExecutor = new ThreadPoolTaskExecutor();
        poolExecutor.setCorePoolSize(5);
        poolExecutor.setMaxPoolSize(5);
        poolExecutor.setQueueCapacity(100);
        poolExecutor.setKeepAliveSeconds(20);
        poolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        poolExecutor.setThreadNamePrefix("SimpleAsyncTaskExecutor-");
        poolExecutor.initialize();
        return poolExecutor;
    }
}
