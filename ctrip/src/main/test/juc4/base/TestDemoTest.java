package juc4.base;


import juc4.junit.TestDemo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestDemoTest {

    @Test
    void scoreLevel1(){
        TestDemo testDemo = new TestDemo();
        assertEquals(testDemo.scoreLevel(60),"弱");
    }
    @Test
    void scoreLevel2(){
        TestDemo testDemo = new TestDemo();
        assertEquals(testDemo.scoreLevel(70),"差");
    }
}