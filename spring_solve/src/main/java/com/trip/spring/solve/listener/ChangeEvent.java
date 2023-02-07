package com.trip.spring.solve.listener;

import org.springframework.context.ApplicationEvent;

import java.io.Serializable;

/**
 * @author xbguo
 * @date 2023/2/7 16:13
 */
public class ChangeEvent extends ApplicationEvent implements Serializable {
    private static final  long serialVersionUID = 0L;
    private String state;

    public ChangeEvent(Object source) {
        super(source);
    }

    public ChangeEvent(Object source, String state) {
        super(source);
        this.state = state;
    }

    @Override
    public String toString() {
        return "ChangeEvent{" +
                "state='" + state + '\'' +
                ", source=" + source +
                '}';
    }
}
