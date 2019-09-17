package com.tongyl.example.jdemoenummybaits.mapper;

import com.tongyl.example.jdemoenummybaits.entity.Computer;
import com.tongyl.example.jdemoenummybaits.entity.ComputerExample;
import com.tongyl.example.jdemoenummybaits.handler.CodeEnumTypeHandler;
import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface ComputerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_computer
     *
     * @mbg.generated Wed Sep 04 11:25:38 GMT+08:00 2019
     */
    @SelectProvider(type=ComputerSqlProvider.class, method="countByExample")
    long countByExample(ComputerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_computer
     *
     * @mbg.generated Wed Sep 04 11:25:38 GMT+08:00 2019
     */
    @DeleteProvider(type=ComputerSqlProvider.class, method="deleteByExample")
    int deleteByExample(ComputerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_computer
     *
     * @mbg.generated Wed Sep 04 11:25:38 GMT+08:00 2019
     */
    @Insert({
        "insert into t_computer (id, name, ",
        "computer_state, ",
        "create_time, update_time)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{computerState,jdbcType=INTEGER,typeHandler=com.tongyl.example.jdemoenummybaits.handler.CodeEnumTypeHandler}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(Computer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_computer
     *
     * @mbg.generated Wed Sep 04 11:25:38 GMT+08:00 2019
     */
    @InsertProvider(type=ComputerSqlProvider.class, method="insertSelective")
    int insertSelective(Computer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_computer
     *
     * @mbg.generated Wed Sep 04 11:25:38 GMT+08:00 2019
     */
    @SelectProvider(type=ComputerSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="computer_state", property="computerState", typeHandler=CodeEnumTypeHandler.class, jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Computer> selectByExampleWithRowbounds(ComputerExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_computer
     *
     * @mbg.generated Wed Sep 04 11:25:38 GMT+08:00 2019
     */
    @SelectProvider(type=ComputerSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="computer_state", property="computerState", typeHandler=CodeEnumTypeHandler.class, jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Computer> selectByExample(ComputerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_computer
     *
     * @mbg.generated Wed Sep 04 11:25:38 GMT+08:00 2019
     */
    @UpdateProvider(type=ComputerSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Computer record, @Param("example") ComputerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_computer
     *
     * @mbg.generated Wed Sep 04 11:25:38 GMT+08:00 2019
     */
    @UpdateProvider(type=ComputerSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Computer record, @Param("example") ComputerExample example);
}