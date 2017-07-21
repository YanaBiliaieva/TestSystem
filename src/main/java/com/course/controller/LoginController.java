package com.course.controller;

import com.course.domains.User;
import com.course.service.ServiceFactory;
import com.course.validation.RegExp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Alexey on 29.04.2017.
 */
public class LoginController implements Controller {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        String login = request.getParameter("userlogin");
        String password = request.getParameter("userpassword");
//        TODO validation
        if(!RegExp.isCorrectLoginName(login) || !RegExp.isCorrectPassword(password) ){
            request.setAttribute("error","Login incorrect");
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            try {
                rd.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ///receive user by entered data
        User user = ServiceFactory.getInstance().getLoginService().loginVerify(login,password);
        if(user==null){
            request.setAttribute("error","Login incorrect!");
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            try {
                rd.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ///put user in session if user exists
        HttpSession session = request.getSession(true);
        session.setAttribute("user",user);
        ///redirect to profile page
        try {
            response.sendRedirect("/profile");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
