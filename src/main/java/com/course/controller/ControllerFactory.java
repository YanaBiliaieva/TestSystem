package com.course.controller;

import javax.servlet.http.HttpServletRequest;


public interface ControllerFactory {

    Controller getController(HttpServletRequest request);

}
