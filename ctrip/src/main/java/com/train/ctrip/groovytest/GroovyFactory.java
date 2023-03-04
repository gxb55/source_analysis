package com.train.ctrip.groovytest;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author xbguo
 * @date 2023/3/1 14:36
 */
public class GroovyFactory {
    private static ScriptEngine engine = new ScriptEngineManager().getEngineByName("groovy");

    public static Object invokeGroovyMethod(String path) throws Exception {
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        StringBuilder stringBuilder = new StringBuilder();
        String len = "";
        while ((len = bufferedReader.readLine()) != null) {
            stringBuilder.append(len).append(System.getProperty("line.separator"));
        }
        System.out.println(stringBuilder.toString());
        String str = stringBuilder.toString();
        Class helloClass = groovyClassLoader.parseClass(str);
        GroovyObject object = (GroovyObject) helloClass.newInstance();
        Object ret = object.invokeMethod("handle", null); // 控制台输出"hello, vivo"

        return ret;
    }
}
