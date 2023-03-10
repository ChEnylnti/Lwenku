package com.hbnu.Lwenku.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class TransactionUtil {
    private static DataSource dataSource = new ComboPooledDataSource();
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection(){
        Connection con = tl.get();
        if(con == null) {
            try {
                return dataSource.getConnection();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return con;
    }

    public static void beginTransaction() throws SQLException {
        Connection con = tl.get();
        if(con != null) {
            throw new SQLException("事务已经开启，在没有结束当前事务时，不能再开启事务！");
        }
        con = dataSource.getConnection();
        con.setAutoCommit(false);
        tl.set(con);
    }

    public static void commitTransaction() throws SQLException {
        Connection con = tl.get();
        if(con == null) {
            throw new SQLException("当前没有事务，所以不能提交事务！");
        }
        con.commit();
        con.close();
        tl.remove();
    }

    public static void rollbackTransaction() throws SQLException {
        Connection con = tl.get();
        if(con == null) {
            throw new SQLException("当前没有事务，所以不能回滚事务！");
        }
        con.rollback();
        con.close();
        tl.remove();
    }

}
