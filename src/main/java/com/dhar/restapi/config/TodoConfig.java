package com.dhar.restapi.config;

import com.dhar.restapi.service.TodoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoConfig {

    @Bean
    public TodoServiceImpl todoService() {
        return new TodoServiceImpl();
    }
}