package com.tongyl.example.jdemoenummybaits.handler;

import com.tongyl.example.jdemoenummybaits.emum.BaseCodeEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Created by Tunyl on 2019/9/4.
 * @version 1.0
 */
public class CodeEnumTypeHandler<E extends  Enum<?> & BaseCodeEnum> extends BaseTypeHandler<BaseCodeEnum> {

     private Class<E> type;
     public CodeEnumTypeHandler(Class<E> type){
         if(type == null){
             throw new IllegalArgumentException("Type argument cannot be null");
         }
         this.type = type;
     }
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, BaseCodeEnum baseCodeEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,baseCodeEnum.getCode());
    }

    @Override
    public BaseCodeEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int code =   resultSet.getInt(s);
        return resultSet.wasNull()?null:codeOf(code);
    }

    @Override
    public BaseCodeEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
         int code =  resultSet.getInt(i);
         return resultSet.wasNull()?null:codeOf(code);
    }

    @Override
    public BaseCodeEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
         int code = callableStatement.getInt(i);
        return callableStatement.wasNull()?null:codeOf(code);
    }


    private E codeOf(int code){
         try {
             return codeOf(type, code);
         }catch(Exception ex){
             throw new IllegalArgumentException("Cannot convert " + code + "to" + type.getSimpleName());
         }

    }


    public static <E extends Enum<?> & BaseCodeEnum> E codeOf(Class<E> enumClass, int code) {
        E[] enumConstants = enumClass.getEnumConstants();
        for (E e : enumConstants) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }

}
