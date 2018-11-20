package com.gfyw.client.server;

import com.gfyw.client.FeignConfig;
import com.gfyw.client.server.impl.Hystrix_fullback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 调服务端
 */
@FeignClient(value = "example-three",fallback = Hystrix_fullback.class,configuration = FeignConfig.class)
public interface FeignService {
    @GetMapping("users")
    String users();

    @GetMapping("examplethree/{name}")
    String hello(@PathVariable(value = "name") String name);

    @GetMapping("user/{id}")
    public String getUserById(@PathVariable(value = "id") Integer id);
}
