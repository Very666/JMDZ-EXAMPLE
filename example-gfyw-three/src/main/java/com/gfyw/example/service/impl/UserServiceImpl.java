package com.gfyw.example.service.impl;

import com.gfyw.example.bean.User;
import com.gfyw.example.dao.UserMapper;
import com.gfyw.example.service.UserService;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@SuppressWarnings("ALL")
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserById(@NonNull Integer uid) {
        return userMapper.getUserById(uid);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public int update(Integer id , User user) {
        return userMapper.update(id , user);
    }

    @Override
    public int delete(Integer id) {
        return userMapper.delete(id);
    }
}
