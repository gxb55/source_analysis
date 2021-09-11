package com.trip.spring_mybatis.config.mq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * 消费者
 * @author Administrator
 */
public class RocketMqConsumer {
    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("cg");
        consumer.setNamesrvAddr(MQConstant.HOST);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        // 指定topic 和tag
        consumer.subscribe(MQConstant.SOME_TOPIC,"*");

        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
               for(MessageExt msg:list){
                   System.out.println(msg);
               }
               // 消费成功
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        System.out.println("consumer end");
    }
}
/**
 * org.apache.rocketmq.client.impl.consumer.DefaultMQPushConsumerImpl#start()
 * 1.检测相关配置
 * 2.
 *
 *
 * org.apache.rocketmq.client.impl.consumer.DefaultMQPushConsumerImpl#pullMessage(org.apache.rocketmq.client.impl.consumer.PullRequest)
 * PullRequest
 *
 *
 */