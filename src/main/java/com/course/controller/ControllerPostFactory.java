package com.course.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


public class ControllerPostFactory implements ControllerFactory{


    private static ControllerFactory factory = new ControllerPostFactory();
    private Map<String,Controller> controllersMap = new HashMap<>();

    private ControllerPostFactory(){
        controllersMap.put("login",new LoginController());
        controllersMap.put("registration",new RegistrationController());
    }

    public Controller getController(HttpServletRequest request){
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