package com.tunyl.inceptorDemo;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;

/**
 * @author create by Tunyl on 2020/3/3
 * @version 1.0
 */
public class HikDemo {
    private static HikariDataSource dataSource;
    public static void main(String[] args) throws SQLException {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.apache.hive.jdbc.HiveDriver");
        config.setJdbcUrl("jdbc:hive2://tdh-2:10000/light_dev");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        dataSource =  new HikariDataSource(config);

        Connection connection = dataSource.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM `tta`;");
        ResultSetMetaData rsmd = rs.getMetaData();
        int size = rsmd.getColumnCount();
        while(rs.next()) {
            StringBuffer value = new StringBuffer();
            for(int i = 0; i < size; i++) {
                value.append(rs.getString(i+1)).append("\t");
            }
            System.out.println(value.toString());
        }
        rs.close();
        stmt.close();
        connection.close();



    }
}
