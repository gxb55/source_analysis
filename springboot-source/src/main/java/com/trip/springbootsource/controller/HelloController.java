package com.trip.springbootsource.controller;

import com.trip.springbootsource.module.Response;
import com.trip.springbootsource.module.User;
import com.trip.springbootsource.service.TestServiceInterface;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author xbguo
 * @createTime 2023年02月12日 12:13:00
 */
@RestController
public class HelloController {

    @Resource
    private TestServiceInterface serviceInterface;
    @GetMapping("/hello")
    public String sayHello(){
        return "hi Boot";
    }

    @PostMapping(value = "/addUser")
    public Response addUser(@RequestBody User user){
        return serviceInterface.addUser(user);
    }
    @PostMapping(value = "/delUser")
    public Response delUser(@RequestBody User user){
        return serviceInterface.delUser(user);
    }
    @PostMapping(value = "/queryUserList")
    public Response queryUserList(){
        return serviceInterface.queryUserList();
    }
}
