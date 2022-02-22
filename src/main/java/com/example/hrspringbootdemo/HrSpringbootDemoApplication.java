package com.example.hrspringbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class HrSpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrSpringbootDemoApplication.class, args);

    }

}
