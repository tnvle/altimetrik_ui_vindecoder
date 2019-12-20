package com.example.demoaltiui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DemoaltiuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoaltiuiApplication.class, args);
    }

}
