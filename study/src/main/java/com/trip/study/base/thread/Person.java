package com.trip.study.base.thread;

/**
 * @author xbguo
 * @createTime 2022年11月27日 09:42:00
 */
public class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void changeName(String name) {
        synchronized (this.age) {
            System.out.println(Thread.currentThread().getName() + "changeName,age");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (this.name) {
                System.out.println(Thread.currentThread().getName() + "changeName,name");
                this.name = name;
            }
        }
    }

    public void changeAge(Integer age) {
        synchronized (this.name) {
            System.out.println(Thread.currentThread().getName() + "changeAge,name");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (this.age) {
                System.out.println(Thread.currentThread().getName() + "changeAge,age");
                this.age = age;
            }
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
