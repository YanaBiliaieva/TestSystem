package com.course.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public interface Controller {

    void execute(HttpServletRequest request, HttpServletResponse response);

}
