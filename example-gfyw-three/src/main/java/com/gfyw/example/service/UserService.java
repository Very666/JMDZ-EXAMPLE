package com.gfyw.example.service;




import com.gfyw.example.bean.User;

import java.util.List;

public interface UserService {

    public User getUserById(Integer id);

    public List<User> getAllUser();

    public int add(User user);

    public int update(Integer id, User user);

    public int delete(Integer id);
}
