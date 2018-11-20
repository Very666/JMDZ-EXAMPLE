package com.gfyw.client.server.impl;

import com.gfyw.client.server.FeignService;
import org.springframework.stereotype.Component;

/**
 * 熔断回调类,用于熔断后回调
 */
@Component
public class Hystrix_fullback implements FeignService {

    @Override
    public String users() {
        return "users 消息发送失败";
    }

    @Override
    public String hello(String name) {
        return "examplethree 消息发送失败";
    }

    @Override
    public String getUserById(Integer id) {
        return "getUserById 消息发送失败";
    }
}
