package com.trip.springmvc.controller;

import com.trip.springmvc.exception.InvalidUserException;
import com.trip.springmvc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author xbguo
 * @createTime 2023年02月07日 22:07:00
 */
//@RestController
@Controller
public class HelloController {

    @Autowired
    HelloService helloService;

    /**
     * https://docs.spring.io/spring-framework/docs/5.3.25/reference/html/web.html#mvc-ann-arguments 能够处理的方法类型 方法签名
     * <p>
     * https://docs.spring.io/spring-framework/docs/5.3.25/reference/html/web.html#mvc-ann-return-types 能够处理的方法返回值
     * Method Arguments
     *
     * @return
     */
    @GetMapping("/hello")
    public String sayHello(String name, @RequestParam("user") String user, HttpSession httpSession,int i) {
        int x = 1 / i;
        if(user.equals("abc")){
            throw new InvalidUserException();
        }
        String mvc = helloService.sayHello(user + "MVC" + name);
        httpSession.setAttribute("msg", mvc);
        return "index.jsp";
    }

    @GetMapping("/beauty")
    public String beauty(String name, Model model) {
        model.addAttribute("姓名", "reba");
        // 自定义视图解析器
        return "beauty:" + name;
    }


    public HelloController() {
        System.out.println("HelloController");
    }
}
