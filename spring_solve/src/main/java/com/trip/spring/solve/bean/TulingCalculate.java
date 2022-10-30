package com.trip.spring.solve.bean;

import org.springframework.stereotype.Component;

@Component
public class TulingCalculate implements Calculate {
    @Override
    public int add(int x, int y) {
        String a= null;
      //  a.equals("4");
        return x+y;
    }
}
