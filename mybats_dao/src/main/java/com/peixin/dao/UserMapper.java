package com.peixin.dao;

import com.peixin.domain.User;


import java.util.List;

public interface UserMapper {
     List<User> findAll() ;

    User findById(int id);

}
