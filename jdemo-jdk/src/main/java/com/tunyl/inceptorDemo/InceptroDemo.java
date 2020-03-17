package com.tunyl.inceptorDemo;

import java.sql.*;

/**
 * @author create by Tunyl on 2020/3/3
 * @version 1.0
 */
public class InceptroDemo {

        //Hive2 Driver class name
        private static String driverName = "org.apache.hive.jdbc.HiveDriver";

        public static void main(String[] args) throws SQLException {
            try {
                Class.forName(driverName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.exit(1);
            }

            //Hive2 JDBC URL with LDAP
            String jdbcURL = "jdbc:hive2://tdh-2:10000/light_dev";

            Connection conn = DriverManager.getConnection(jdbcURL);
            Statement stmt = conn.createStatement();
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
            conn.close();
        }
    }

