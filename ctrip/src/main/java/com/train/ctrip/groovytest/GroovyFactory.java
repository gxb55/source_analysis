package com.train.ctrip.groovytest;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.Objects;

/**
 * @author xbguo
 * @date 2023/3/1 14:36
 */
@Component
public class GroovyFactory implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public Object invokeGroovyMethod(String path, Object o) throws Exception {
        String str = getClassStr(path);
        long l = System.currentTimeMillis();
        Class helloClass = new GroovyClassLoader().parseClass(str);
        System.out.println(System.currentTimeMillis()-l);
        GroovyObject object = (GroovyObject) helloClass.getDeclaredConstructor().newInstance();
        populateBean(object);
        // 控制台输出"hello, vivo"
        Object ret = object.invokeMethod("handle", o);
        return ret;
    }

    private String getClassStr(String path) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        StringBuilder stringBuilder = new StringBuilder();
        String len = "";
        while ((len = bufferedReader.readLine()) != null) {
            stringBuilder.append(len).append(System.getProperty("line.separator"));
        }
        System.out.println(stringBuilder);
        return stringBuilder.toString();
    }

    public void populateBean(Object ret) throws IllegalAccessException {
        if (applicationContext == null) {
            return;
        }
        Field[] fields = ret.getClass().getDeclaredFields();;
        for (Field f : fields) {
            Object bean = null;
            Autowired annotation = AnnotationUtils.findAnnotation(f, Autowired.class);
            if (Objects.nonNull(annotation)) {
                Class<?> type = f.getType();
                bean = applicationContext.getBean(type);
                if (Objects.nonNull(bean)) {
                    f.set(ret, bean);
                }
            }
            Resource resource = AnnotationUtils.getAnnotation(f, Resource.class);
            if (Objects.nonNull(resource)) {
                String name = resource.name();
                if (StringUtils.isNotBlank(name)) {
                    bean = applicationContext.getBean(name);
                } else {
                    bean = applicationContext.getBean(f.getType());
                }
            }
            if (Objects.nonNull(bean)) {
                f.setAccessible(true);
                f.set(ret, bean);
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
