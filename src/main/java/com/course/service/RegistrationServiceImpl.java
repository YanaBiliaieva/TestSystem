package com.course.service;

import com.course.dao.DaoFactory;
import com.course.dao.utils.TransactionHelper;
import com.course.dao.utils.exceptions.DaoException;
import com.course.dao.utils.exceptions.ServiceException;
import com.course.dao.utils.exceptions.UserAlreadyExistException;
import com.course.dao.utils.exceptions.UserExistException;
import com.course.domains.User;
import com.course.dto.UserDTO;


public class RegistrationServiceImpl implements RegistrationService {

    @Override
    public void saveUser(UserDTO userDTO) {

        try {
            TransactionHelper.getInstance().beginTransaction();

            User user = new User.Builder()
                    .setLogin(userDTO)
                    .setName(userDTO)
                    .setPassword(userDTO)
                    .build();
            DaoFactory.getInstance().getUserDao().saveUser(user);

            TransactionHelper.getInstance().commit();

        }catch (DaoException ex){
            TransactionHelper.getInstance().rollback();
            throw new ServiceException(ex);
        }catch (UserAlreadyExistException ex){
            TransactionHelper.getInstance().rollback();
            throw new UserExistException(ex);
        }
    }

}
