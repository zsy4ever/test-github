package com.zsl.homestay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = {"com.zsl.homestay.mapper"})
public class HomestayApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomestayApplication.class, args);
    }

}
