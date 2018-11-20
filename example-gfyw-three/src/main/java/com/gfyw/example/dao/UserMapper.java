package com.gfyw.example.dao;

import com.gfyw.example.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("select * from tb_user where id = #{id}")
    public User getUserById(Integer id);
    @Select("select * from tb_user")
    public List<User> getAllUser();
    @Insert("insert into tb_user(username,age,ctm) values(#{username},#{age},now())")
    public int add(User user);
    @Update("update tb_user set username = #{username},ctm = now() where id = #{id}")
    public int update(@Param("id") Integer id, User user);
    @Delete("delete from tb_user where id = #{id}")
    public int delete(Integer id);
}
