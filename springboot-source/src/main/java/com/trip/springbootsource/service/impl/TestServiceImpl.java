package com.trip.springbootsource.service.impl;

import com.trip.springbootsource.module.Response;
import com.trip.springbootsource.module.User;
import com.trip.springbootsource.service.TestServiceInterface;
import com.trip.springbootsource.util.CSVUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class TestServiceImpl implements TestServiceInterface, SmartLifecycle {
    private Map<Long, User> map;
    private static final String PATH = "user.csv";

    public TestServiceImpl() {
        List<User> list = CSVUtil.readCsv(PATH, User.class);
        this.map = new HashMap<>();
        if (CollectionUtils.isNotEmpty(list)) {
            list.stream().forEach(x -> map.put(x.getId(), x));
        }
    }

    @Override
    public Response addUser(User user) {
        long l = System.currentTimeMillis();
        user.setId(l);
        map.put(l, new User(l, user.getName(), user.getAge()));
        return Response.getSuccessResponse();
    }

    @Override
    public Response delUser(User user) {
        Long id = user.getId();
        map.remove(id);
        return Response.getSuccessResponse();
    }

    @Override
    public Response queryUserList() {
        List<User> collect = map.entrySet().stream().map(x -> x.getValue()).collect(Collectors.toList());
        Response successResponse = Response.getSuccessResponse();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("userList", collect);
        successResponse.setData(map1);
        return successResponse;

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {
        CSVUtil.writeCsv(map.entrySet().stream().map(x -> x.getValue()).collect(Collectors.toList()), PATH);
    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
