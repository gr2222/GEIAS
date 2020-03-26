package com.gr.geias;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gr.geias.mapper")
public class GeiasApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeiasApplication.class, args);
    }

}
