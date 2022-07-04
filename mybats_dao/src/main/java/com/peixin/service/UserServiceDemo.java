package com.peixin.service;

import com.peixin.dao.impl.UserMapperImpl;
import com.peixin.domain.User;

import java.io.IOException;
import java.util.List;

public class UserServiceDemo {
    public static void main(String[] args)  {
        //创建dao对象
        UserMapperImpl userMapper = new UserMapperImpl();
        List<User> all = userMapper.findAll();
        System.out.println(all);

        User byId = userMapper.findById(1);
        System.out.println(byId);

    }
}

