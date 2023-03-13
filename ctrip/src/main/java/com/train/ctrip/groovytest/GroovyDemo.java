package com.train.ctrip.groovytest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/3/1 14:28
 */
public class GroovyDemo {
    public static void main(String[] args) throws Exception {
        GroovyFactory groovyFactory = new GroovyFactory();
        Map<String, String> map = new HashMap<>();
        map.put("name", "a");
        Object o = groovyFactory.invokeGroovyMethod("D:\\WorkSpace\\workspace\\2023work\\source_analysis\\ctrip\\src\\main\\java\\groovytest\\CouponAlterHandler.groovy", map);
        System.out.println(o);
    }
}
