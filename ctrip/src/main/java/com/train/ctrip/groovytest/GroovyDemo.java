package com.train.ctrip.groovytest;

/**
 * @author xbguo
 * @date 2023/3/1 14:28
 */
public class GroovyDemo {
    public static void main(String[] args) throws Exception {

        Object o = GroovyFactory.invokeGroovyMethod("D:\\WorkSpace\\workspace\\2023work\\source_analysis\\ctrip\\src\\main\\java\\groovytest\\CouponAlterHandler.groovy");
        System.out.println(o);
    }
}
