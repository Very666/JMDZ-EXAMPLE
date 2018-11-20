package com.gfyw.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 赵文涛
 * @MapperScan mapper扫描
 * @EnableSwagger2 api
 * @EnableEurekaClient 服务提供
 */
@SpringBootApplication
@MapperScan("com.gfyw.example.dao")
@EnableSwagger2
@EnableEurekaClient
public class ExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }
}
