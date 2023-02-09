package com.trip.springmvc.controller;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xbguo
 * @date 2023/2/9 19:37
 * @description SimpleControllerHandlerAdapter
 */
@org.springframework.stereotype.Controller("/helloSimple")
public class HelloSimpleController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return null;
    }
}
