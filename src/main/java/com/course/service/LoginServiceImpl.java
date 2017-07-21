package com.course.service;

import com.course.dao.DaoFactory;
import com.course.dao.utils.exceptions.DaoException;
import com.course.dao.utils.exceptions.ServiceException;
import com.course.domains.User;


/**
 * Created by Alexey on 29.04.2017.
 */
public class LoginServiceImpl implements LoginService {

    @Override
    public User loginVerify(String login, String password) {
        User user;
        try {
            user = DaoFactory.getInstance().getUserDao().getUserByLogin(login);
            if (user == null || !user.getPassword().equals(password)) {
                return null;
            }
        }catch (DaoException e){
            throw new ServiceException(e);
        }
        return user;
    }
}