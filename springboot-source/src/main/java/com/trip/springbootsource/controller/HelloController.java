package com.trip.springbootsource.controller;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xbguo
 * @createTime 2023年02月12日 12:13:00
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(){
        return "hi Boot";
    }
}
