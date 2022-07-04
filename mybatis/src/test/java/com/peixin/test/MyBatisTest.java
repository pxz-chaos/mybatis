package com.peixin.test;

import com.peixin.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    @Test
    public void testDelete() throws IOException {

        //配置核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行操作 参数：namespace+id

      sqlSession.delete("userMapper.delete",5);//删除8号

        //mybatis执行更新操作需要提交事务

        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }


    @Test
    public void testUpdate() throws IOException {
        //模拟user对象
        User user = new User();
        user.setUsername("lucy");
        user.setPassword("1234");
        user.setId(8);



        //配置核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行操作 参数：namespace+id

        sqlSession.update("userMapper.update", user);

        //mybatis执行更新操作需要提交事务

        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Test
    public void testInsert() throws IOException {
        //模拟user对象
        User user = new User();
        user.setUsername("tom");
        user.setPassword("123");


        //配置核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //执行操作 参数：namespace+id

        sqlSession.insert("userMapper.save", user);

        //mybatis执行更新操作需要提交事务，openSession的自动提交功能默认为false

//        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Test
    public void testQuery() throws IOException {

        //配置核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行操作 参数：namespace+id
        List<User> selectList = sqlSession.selectList("userMapper.findAll");

        //打印数据
        System.out.println(selectList);

        //释放资源
        sqlSession.close();
    }

    @Test
    public void testQueryOne() throws IOException {

        //配置核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行操作 参数：namespace+id
        Object selectOne = sqlSession.selectOne("userMapper.findOne","zhangsan");

        //打印数据
        System.out.println(selectOne);

        //释放资源
        sqlSession.close();
    }
}
