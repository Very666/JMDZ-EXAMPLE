package com.gfyw.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zwt
 * @EnableAdminServer 开启admin监控
 * 1.配置文件没有往配置中心放
 * 2.被监控服务的安全登录设置只需要改配置文件,修改方法同此服务,安全配置类不需要添加
 */
@SpringBootApplication
@EnableAdminServer
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}
