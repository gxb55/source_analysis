package com.trip.spring.solve.listener;

import org.springframework.context.ApplicationEvent;

import java.io.Serializable;

/**
 * @author xbguo
 * @date 2023/2/7 16:15
 */
public class MessageEvent  extends ApplicationEvent implements Serializable {
    private static final  long serialVersionUID = 0L;

    public MessageEvent(String source) {
        super(source);
    }

    @Override
    public String toString() {
        return "MessageEvent{" +
                "source=" + source +
                '}';
    }
}
