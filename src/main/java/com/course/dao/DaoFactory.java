package com.course.dao;

/**
 * Created by Alexey on 29.04.2017.
 */
public class DaoFactory {

    private static DaoFactory instance = new DaoFactory();
    private UserDao userDao = new UserDao();

    private DaoFactory(){}

    public static DaoFactory getInstance() {
        return instance;
    }

    public UserDao getUserDao() {
        return userDao;
    }
}
