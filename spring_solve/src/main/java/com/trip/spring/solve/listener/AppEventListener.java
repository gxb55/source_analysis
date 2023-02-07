package com.trip.spring.solve.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.trip.spring.solve.bean.circle.A;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author xbguo
 * @date 2023/2/7 16:04
 */
@Component
public class AppEventListener {
    public AppEventListener() {
        System.out.println("AppEventListener...");
    }

    @EventListener(MessageEvent.class)
    public void listenMessage(MessageEvent event){
        System.out.println("MessageEvent handler"+ event);
    }
    @EventListener(ChangeEvent.class)
    public void listenMessage(ChangeEvent event){
        System.out.println("ChangeEvent handler"+ event);
    }

    @EventListener(PayloadApplicationEvent.class)
    public void listenMessage(PayloadApplicationEvent<A> event){
        System.out.println("PayloadApplicationEvent handler"+event.getPayload());
    }

}
