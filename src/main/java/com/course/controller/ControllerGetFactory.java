package com.course.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


public class ControllerGetFactory implements ControllerFactory{


    private static ControllerFactory factory = new ControllerGetFactory();
    private Map<String,Controller> controllersMap = new HashMap<>();

    private ControllerGetFactory(){
        controllersMap.put("registration",new RegistrationGetController());
        controllersMap.put("login",new LoginGetController());
        controllersMap.put(null,new IndexController());
        controllersMap.put("profile",new ProfileController());
        controllersMap.put("logout",new LogOutController());
    }

    public Controller getController(HttpServletRequest request){
        System.out.println(request.getRequestURI());
        String[] req = request.getRequestURI().split("/");
        if (req.length==0){
            return controllersMap.get(null);
        }

        return controllersMap.get(req[req.length-1]);
    }

    public static ControllerFactory getInstance(){
//     if(factory==null) factory = new ControllerFactory();
        return factory;
    }

}