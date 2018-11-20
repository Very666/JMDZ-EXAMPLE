package com.gfyw.example.controller;


import com.alibaba.fastjson.JSON;
import com.gfyw.example.bean.JsonResult;
import com.gfyw.example.bean.User;
import com.gfyw.example.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zwt
 */

@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "serverthree/{name}",method = RequestMethod.GET)
    public String hello (@PathVariable(value = "name") String name) {
        logger.info(name);
        return "server-three, " + name;
    }

    @Autowired
    private UserService userService;

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public String getUserById( @PathVariable(value = "id")  Integer id) {
        User user = userService.getUserById(id);
        logger.info(JSON.toJSONString(user));
        return JSON.toJSONString(user);
    }

    @ApiOperation(value="获取用户列表", notes="获取用户列表")
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String getAllUser() {
        List<User> userList = userService.getAllUser();
        logger.info(JSON.toJSONString(userList));
        return JSON.toJSONString(userList);
    }


/**
 * 添加用户
 * @param user
 * @return
 */

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add (@RequestBody User user){
        JsonResult jsonResult=new JsonResult();
        try {
            int row = userService.add(user);
            jsonResult.setResult(row);
            if (row < 0){
                jsonResult.setStatus("fail");
            } else {
                jsonResult.setStatus("ok");
            }
        }catch (Exception e){
            jsonResult.setResult(e.getClass().getName()+":"+e.getMessage());
            jsonResult.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(jsonResult);
    }


/**
 * 修改用户
 */

    @ApiOperation(value="更新信息", notes="根据url的id来指定更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User")
    })
    @RequestMapping(value = "user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<JsonResult> update (@PathVariable("id") Integer id, @RequestBody User user){
        JsonResult jsonResult=new JsonResult();
        try {
            int row = userService.update(id,user);
            jsonResult.setResult(row);
            if (row < 0){
                jsonResult.setStatus("fail");
            } else {
                jsonResult.setStatus("ok");
            }
        }catch (Exception e){
                jsonResult.setResult(e.getClass().getName()+":"+e.getMessage());
                jsonResult.setStatus("error");
                e.printStackTrace();
        }
        return ResponseEntity.ok(jsonResult);
    }


/**
 * 删除用户
 */

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete(@PathVariable(value = "id") Integer id){
        JsonResult jsonResult=new JsonResult();
        try {
            int row = userService.delete(id);
            jsonResult.setResult(row);
            if (row < 1){
                jsonResult.setStatus("fail");
            } else {
                jsonResult.setStatus("ok");
            }
        }catch (Exception e){
            jsonResult.setResult(e.getClass().getName()+":"+e.getMessage());
            jsonResult.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(jsonResult);
    }
}


