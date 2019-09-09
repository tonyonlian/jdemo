package com.tongyl.example.jdemosb.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.sql.*;

/**
 * 在 Money 与 Long 之间转换的 TypeHandler，处理 CNY 人民币
 * @author Created by Tunyl on 2019/8/27.
 * @version 1.0
 */
public class MoneyTypeHandler extends BaseTypeHandler<Money> {

    /**
     * 用于定义在Mybatis设置参数时该如何把Java类型的参数转换为对应的数据库类型
     * @param preparedStatement 当前的PreparedStatement对象
     * @param i 当前参数的位置
     * @param money 当前参数的Java对象
     * @param jdbcType 当前参数的数据库类型
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Money money, JdbcType jdbcType) throws SQLException {
            preparedStatement.setLong(i, money.getAmountMinorLong());
    }
    /**
     * 用于在Mybatis获取数据结果集时如何把数据库类型转换为对应的Java类型
     * @param resultSet 当前的结果集
     * @param s 当前的字段名称
     * @return 转换后的Java对象
     * @throws SQLException
     */
    @Override
    public Money getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return parseMoney(resultSet.getLong(s));
    }

    /**
     * 用于在Mybatis通过字段位置获取字段数据时把数据库类型转换为对应的Java类型
     * @param resultSet 当前的结果集
     * @param  i 当前字段的位置
     * @return 转换后的Java对象
     * @throws SQLException
     */

    @Override
    public Money getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return parseMoney(resultSet.getLong(i));
    }

    /**
     * 用于Mybatis在调用存储过程后把数据库类型的数据转换为对应的Java类型
     * @param callableStatement 当前的CallableStatement执行后的CallableStatement
     * @param i 当前输出参数的位置
     * @return
     * @throws SQLException
     */
    @Override
    public Money getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return parseMoney(callableStatement.getLong(i));
    }

    private Money parseMoney(Long value) {
        return Money.of(CurrencyUnit.of("CNY"), value / 100.0);
    }
}
