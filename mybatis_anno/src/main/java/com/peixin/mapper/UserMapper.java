package com.peixin.mapper;

import com.peixin.domain.User;
import org.apache.ibatis.annotations.*;


import java.util.List;

public interface UserMapper {
    //增
    @Insert("insert into user values (#{id}, #{username}, #{password}, #{birthday})")
    void save(User user);

    //删
    @Delete("delete from user where id=#{id}")
    void delete(int id);

    //改
    @Update("update user set username=#{username},password=#{password} where id=#{id} ")
    void update(User user);

    //查单个
   @Select("select * from user where id=#{id}")
    User findById(int id);

   //查多个
   @Select("select * from user")
    List<User> findAll();


}
