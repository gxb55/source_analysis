package com.trip.study.rocket.simple;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

/**
 * @author Administrator
 */
public class ProducerOnlySend {

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
        Message message1 = new Message("myTopic001", "hello world001 直接发送不收返回值".getBytes(StandardCharsets.UTF_8));

        // 直接发送不要返回值 不要回调
        producer.sendOneway(message1);


        //producer.shutdown();
        System.out.println("producer 停止了");
    }
}
