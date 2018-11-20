package com.gfyw.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author zwt
 * @EnableZuulProxy zuul代理
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {
  /*  @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }*/

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
