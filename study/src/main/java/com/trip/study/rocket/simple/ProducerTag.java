package com.trip.study.rocket.simple;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

/**
 * @author Administrator
 */
public class ProducerTag {

    public static void main(String[] args) throws Exception {
        // 指定消息所属的group
        DefaultMQProducer producer = new DefaultMQProducer("xoxogp");
        // 连接namespace 然后找到对应的broker
        producer.setNamesrvAddr(MQConstant.NAMESPACE);
        producer.start();
        /**
         * topic
         * value
         */

        for (int i = 0; i < 100; i++) {
            Message message= new Message("myTopic001","TAG_A","KEY01",("hello world001 TAG——A"+i).getBytes(StandardCharsets.UTF_8));
            message.putUserProperty("age",String.valueOf(i));
            // 同步发送消息
            SendResult send = producer.send(message);
            System.out.println(send);
        }


        producer.shutdown();
        System.out.println("producer 停止了");
    }
}
