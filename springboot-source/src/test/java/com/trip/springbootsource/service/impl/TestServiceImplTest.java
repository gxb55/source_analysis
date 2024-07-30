package com.trip.springbootsource.service.impl;

import com.trip.springbootsource.module.Response;
import com.trip.springbootsource.module.User;
import com.trip.springbootsource.service.TestServiceInterface;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@SpringBootTest
class TestServiceImplTest {
    @Mock
    private TestServiceInterface serviceInterface;

    @Test
    void addUser() {
        User user = new User();
        when(serviceInterface.addUser(user)).thenReturn(Response.getSuccessResponse());
        Response response = serviceInterface.addUser(user);
        Assert.assertNotNull(response);
        Assert.assertEquals(response.getResultCode(), Integer.valueOf("1"));
    }

    @Test
    void delUser() {
    }

    @Test
    void queryUserList() {
        Response response = serviceInterface.queryUserList();
        Assert.assertNotNull(response);
        Assert.assertEquals(response.getResultCode(), Integer.valueOf("1"));
    }
}