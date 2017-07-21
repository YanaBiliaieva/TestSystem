package com.course.service;

import com.course.dao.DaoFactory;
import com.course.dao.utils.exceptions.DaoException;
import com.course.domains.User;
import com.course.dto.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Alexey on 29.04.2017.
 */
public class UserServiceImpl implements UserService{

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> usersDTO=null;
        try {
            List<User> users = DaoFactory.getInstance().getUserDao().getAllUser();
            usersDTO = users.stream()
                    .map(user -> new UserDTO.Builder()
                            .setLogin(user)
                            .setName(user)
                            .setPassword(user).build())
                    .collect(Collectors.toList());
        }catch (DaoException ex){
            return usersDTO;
        }
        return usersDTO;
    }
}
