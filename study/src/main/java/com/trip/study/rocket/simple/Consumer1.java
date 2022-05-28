package com.trip.study.rocket.simple;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author Administrator
 *
 * 同一个组下面的consumer只会有一个收到消息
 */
public class Consumer1 {
    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("xxoocsm");
        consumer.setNamesrvAddr(MQConstant.NAMESPACE);
        // topic和过滤条件
        consumer.subscribe("myTopic001","*");
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
        // 默认集群模式只会收到一次消息，广播模式都可以收到消息
        //consumer.setMessageModel(MessageModel.BROADCASTING);
        System.out.println("consumer start ...");
    }
}
