package com.course.service;

import com.course.domains.User;

/**
 * Created by Alexey on 29.04.2017.
 */
public interface LoginService {

    User loginVerify(String login, String password);

}
