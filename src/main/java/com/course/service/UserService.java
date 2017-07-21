package com.course.service;

import com.course.dto.UserDTO;

import java.util.List;

/**
 * Created by Alexey on 29.04.2017.
 */
public interface UserService {

    List<UserDTO> getAllUsers();

}
