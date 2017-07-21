package com.course.dao.utils;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Alexey on 29.04.2017.
 */
public class ConnectionProxy implements Closeable{

    private Connection connection;
    private boolean isTransaction;

    public ConnectionProxy(Connection connection) {
        this.connection = connection;
    }

    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }

    public PreparedStatement createPreparedStatement(String selectUser) throws SQLException {
        return connection.prepareStatement(selectUser);
    }

    public void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        if(!isTransaction) try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rollback(){
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setTransaction(boolean transaction) {
        isTransaction = transaction;
    }
}
