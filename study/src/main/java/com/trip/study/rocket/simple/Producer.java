package com.trip.study.rocket.simple;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class Producer {

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
        Message message1 = new Message("myTopic001","hello world001".getBytes(StandardCharsets.UTF_8));
        Message message2 = new Message("myTopic001","hello world002".getBytes(StandardCharsets.UTF_8));
        Message message3 = new Message("myTopic001","hello world003".getBytes(StandardCharsets.UTF_8));
        Message message4 = new Message("myTopic001","hello world004".getBytes(StandardCharsets.UTF_8));

        List<Message> list = new ArrayList<>();
        list.add(message1);
        list.add(message2);
        list.add(message3);
        list.add(message4);
        // 同步发送消息
        SendResult send = producer.send(list);
        producer.shutdown();
        System.out.println(send);
        System.out.println("producer 停止了");
    }
}
