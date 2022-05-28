package com.trip.study.rocket.simple;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

/**
 * @author Administrator
 */
public class ProducerAsync {

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
        Message message1 = new Message("myTopic001", "hello world001 异步消息".getBytes(StandardCharsets.UTF_8));

        // 同步发送消息
        producer.send(message1, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("成功，" + sendResult);
            }

            @Override
            public void onException(Throwable e) {
                System.out.println("失败，" + e.getStackTrace());
            }
        });


        //producer.shutdown();
        System.out.println("producer 停止了");
    }
}
