package com.trip.springmvc.controller;

import com.trip.springmvc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xbguo
 * @createTime 2023年02月07日 22:07:00
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public String sayHello() {
        String mvc = helloService.sayHello("MVC");
        return mvc;
    }

    public HelloController() {
        System.out.println("HelloController");
    }
}
