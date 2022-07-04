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
import java.util.ArrayList;
import java.util.List;

public class MapperTest {


    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        //模拟条件user
//        User condition = new User();
//        condition.setId(1);
//        condition.setUsername("zhangsan");
//        condition.setPassword("123");


//        模拟ids的数据
        List<Integer> ids=new ArrayList<>();
        ids.add(1);
        ids.add(3);

//        List<User> userList = mapper.findByCondition(condition);
        List<User> userList = mapper.findByIds(ids);
        System.out.println(userList);
    }
}
