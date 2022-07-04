package com.peixin.dao.impl;

import com.peixin.dao.UserMapper;
import com.peixin.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserMapperImpl implements UserMapper {
    static InputStream resourceAsStream = null;
    static UserMapper mapper = null;

    static {

        try {
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @Override
    public List<User> findAll() {
        return mapper.findAll();
    }

    @Override
    public User findById(int id) {
        return mapper.findById(1);

    }
}
