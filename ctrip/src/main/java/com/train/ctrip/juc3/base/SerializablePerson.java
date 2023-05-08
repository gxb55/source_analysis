package com.train.ctrip.juc3.base;

import java.io.Serializable;

/**
 * @author xbguo
 * @createTime 2023年03月22日 22:14:00
 */
public class SerializablePerson implements Serializable {
    private static final long serialVersionUID = 1L;

    private int age;
    private String name;

    public SerializablePerson(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public SerializablePerson() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

    }
}
