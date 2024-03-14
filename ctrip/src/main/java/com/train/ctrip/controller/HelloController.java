package com.train.ctrip.controller;

import com.train.ctrip.groovytest.GroovyFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/3/1 17:24
 */
@RestController
public class HelloController {

    @Resource
    private GroovyFactory groovyFactory;
    @GetMapping("/hi")
    public Object sayHi(String name) throws Exception {
        Map<String,String> map = new HashMap<>();
        map.put("name",name);
       return groovyFactory.invokeGroovyMethod("D:\\WorkSpace\\workspace\\2023work\\source_analysis\\ctrip\\src\\main\\java\\com\\train\\ctrip\\groovytest\\CouponAlterHandler.groovy",map);
    }
}
