package com.gfyw.example.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 赵文涛
 */
@Data
@NoArgsConstructor
public class User {

    private int id;
    private String username;
    private int age;
    private Date ctm;

    public User(String username,int age){
        this.username = username;
        this.age = age;
        this.ctm = new Date();
    }
}
