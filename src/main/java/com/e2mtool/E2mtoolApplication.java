package com.e2mtool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.e2mtool.*.mapper")
public class E2mtoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(E2mtoolApplication.class, args);
    }

}


