package com.trip.study.rocket.order;

import com.trip.study.rocket.simple.MQConstant;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author Administrator
 */
public class Consumer {
    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("orderMsg");
        consumer.setNamesrvAddr(MQConstant.NAMESPACE);


        consumer.registerMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
                for (MessageExt msg : msgs) {
                    System.out.println("consumeMessage  "+Thread.currentThread().getName()+"    " + msg);
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });

        consumer.subscribe("orderTopic", "*");
        consumer.start();
        System.out.println("顺序消费consumer已启动。。。");

    }
}
