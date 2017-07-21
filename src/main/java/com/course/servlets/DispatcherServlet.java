package com.course.servlets;

import com.course.controller.Controller;
import com.course.controller.ControllerGetFactory;
import com.course.controller.ControllerPostFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DispatcherServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     Controller controller = ControllerGetFactory.getInstance().getController(req);
      controller.execute(req,resp);

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     Controller controller = ControllerPostFactory.getInstance().getController(req);
     controller.execute(req,resp);

    }
}
