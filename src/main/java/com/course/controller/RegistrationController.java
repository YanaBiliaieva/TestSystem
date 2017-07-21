package com.course.controller;

import com.course.dao.utils.exceptions.ServiceException;
import com.course.dao.utils.exceptions.UserExistException;
import com.course.dto.UserDTO;
import com.course.service.ServiceFactory;
import com.course.validation.RegExp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationController implements Controller {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("username");
        String login = request.getParameter("userlogin");
        String password = request.getParameter("userpassword");
        //TODO validation

        if(!RegExp.isCorrectLoginName(login) ||
                !RegExp.isCorrectPassword(password) ||
                !RegExp.isCorrectLoginName(name)){
            request.setAttribute("error","Credentials incorrect");
            RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
            try {
                rd.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        UserDTO userDTO = new UserDTO(name,login,password);
//        if(!ServiceFactory.getInstance().getRegistrationService().saveUser(userDTO)){
//            request.setAttribute("error","User already exist!");
//            return "/registration.jsp";
//        }

        try {
            ServiceFactory.getInstance().getRegistrationService().saveUser(userDTO);
        }catch (UserExistException ex){
            request.setAttribute("error","User already exist!");
            RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
            try {
                rd.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch (ServiceException ex){
            ///exception on dao side
        }


        try {
            response.sendRedirect("/index.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
