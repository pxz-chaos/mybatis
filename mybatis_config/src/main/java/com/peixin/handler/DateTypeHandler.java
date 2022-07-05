package com.peixin.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;

public class DateTypeHandler extends BaseTypeHandler<Date> {


    //将java类型 转化为 数据库需要的类型

    /**
     * @param preparedStatement 预编译的SQL语句
     * @param i                 参数位置
     * @param date              时间
     * @param jdbcType          类型
     * @throws SQLException 异常
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {

        preparedStatement.setDate(i,date);
    }


    /**
     * 将数据库中的某些类型转化为java类型
     *
     * @param resultSet 获取到的结果集
     * @param s         需要转化的字段名称
     * @return 时间类型
     * @throws SQLException 抛出SQL异常
     */
    @Override
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {

        //获取结果集中需要的数据(long) 转化为date型 返回

        return resultSet.getDate(s);
    }

    //将数据库中的某些类型转化为java类型
    @Override
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getDate(i);
    }

    //将数据库中的某些类型转化为java类型
    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getDate(i);
    }
}
