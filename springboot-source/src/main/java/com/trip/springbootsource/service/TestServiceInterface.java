package com.trip.springbootsource.service;

import com.trip.springbootsource.module.Response;
import com.trip.springbootsource.module.User;

public interface TestServiceInterface {
    Response addUser(User user);

    Response delUser(User user);

    Response queryUserList();
}
