package com.hikuley;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ="com.hikuley")
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        System.out.println(123);
        SpringApplication.run(Application.class, args);
    }


}
