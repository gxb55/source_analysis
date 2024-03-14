package com.train.ctrip;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TestDemo1 {
    @Test
    public void testAdd() {
        int a = 10;
        int b = 10;
        Assert.assertEquals(a + b, 30);
    }
}
