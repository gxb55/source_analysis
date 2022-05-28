package com.trip.study.rocket.simple;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author Administrator
 */
public class ConsumerTag {
    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("xxoocsm");
        consumer.setNamesrvAddr(MQConstant.NAMESPACE);


        // topic和过滤条件
        consumer.subscribe("myTopic001",MessageSelector.bySql("age >= 16 and age<=30"));

        // 监听器模式消费，不阻塞
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
               for(MessageExt messageExt:msgs){
                   System.out.println(new String(messageExt.getBody()));
               }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        consumer.start();
        System.out.println("consumer start ...");
    }
}
