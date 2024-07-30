package juc4.junit;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 * @BeforeEach
 * @Test
 * @AfterEach
 */
class CalcDemoTest {
    CalcDemo calcDemo = null;

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll");
    }

    @BeforeEach
    void setUp() {
        calcDemo = new CalcDemo();
        System.out.println("BeforeEach come in");
    }

    @AfterEach
    void tearDown() {
        calcDemo = null;
        System.out.println("AfterEach come in");
    }

    @Test
    void add() {
        Assert.assertEquals(calcDemo.add(2, 4), 6);
    }

    @Test
    void sub() {
        Assert.assertEquals(calcDemo.sub(2, 4), -2);
    }
}