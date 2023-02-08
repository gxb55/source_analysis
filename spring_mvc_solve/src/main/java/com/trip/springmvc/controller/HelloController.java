package com.trip.springmvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xbguo
 * @createTime 2023年02月07日 22:07:00
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello,SpringMVC";
    }

    public HelloController() {
        System.out.println("HelloController");
    }
}
