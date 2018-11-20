package com.gfyw.client.controller;

import com.gfyw.client.server.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 浏览器请求
 */
@RestController
public class Hystrix_feignController {

    @Autowired
    private FeignService feignService;

    @GetMapping("/users")
    public String users() {
        return feignService.users();
    }

    @GetMapping("exampleone/{name}")
    public String hello(@PathVariable(value = "name") String name) {
        return feignService.hello(name);
    }

    @GetMapping("user/{id}")
    public String getUserById(@PathVariable(value = "id") Integer id) {
        return feignService.getUserById(id);
    }
}
