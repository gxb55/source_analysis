package juc4.base;

public class EqualsDemo {
    public static void main(String[] args) {
        String s = new String("abc");
        Person person = new Person("abc");
        person.equals(new Person("aa"));
        person.hashCode();
    }
}
