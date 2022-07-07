package com.peixin.test;


import com.peixin.domain.User;
import com.peixin.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;


public class MapperTest {
    static SqlSession sqlSession = null;

    static UserMapper userMapper = null;

    static {
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }


    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("jack");

        userMapper.save(user);

    }

    @Test
    public void testDelete() {
        userMapper.delete(10);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(9);
        user.setUsername("jack");
        user.setPassword("123");
        userMapper.update(user);
    }

    @Test
    public void testFindById() {
        User user = userMapper.findById(9);
        System.out.println(user);
    }

    @Test
    public void testFindAll() {
        for (User user : userMapper.findAll()) {
            System.out.println(user);
        }

    }
    @Test
    public void testQueryMulti() {
        for (User user : userMapper.findAll()) {
            System.out.println(user);
        }

    }

}
