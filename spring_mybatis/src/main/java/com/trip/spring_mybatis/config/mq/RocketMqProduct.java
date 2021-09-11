package com.trip.spring_mybatis.config.mq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * @author Administrator
 */
public class RocketMqProduct {


    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        // pg为product group名称
        DefaultMQProducer producer = new DefaultMQProducer("pg");
        //指定nameserver地址
        producer.setNamesrvAddr(MQConstant.HOST);
        //错误重试次数
        producer.setRetryTimesWhenSendFailed(2);
        // 发送消息超时时间，默认3秒，调整为5秒
        producer.setSendMsgTimeout(5000);

        producer.start();

        for (int i = 0; i < 100; i++) {
            String str = UUID.randomUUID().toString().substring(0, 10) + "_" + i;

            Message message = new Message(MQConstant.SOME_TOPIC, "someTag", str.getBytes(StandardCharsets.UTF_8));
            message.setKeys("key-" + i);
            SendResult send = producer.send(message);
            System.out.println(send);
        }
    }
}
