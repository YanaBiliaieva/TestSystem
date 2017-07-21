package com.course.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RegistrationGetController implements Controller{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("/registration.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
