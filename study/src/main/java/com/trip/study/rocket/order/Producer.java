package com.trip.study.rocket.order;

import com.trip.study.rocket.simple.MQConstant;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author Administrator
 */
public class Producer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("orderMsg");
        producer.setNamesrvAddr(MQConstant.NAMESPACE);
        producer.start();

        for (int i = 0; i < 20; i++) {
            Message message = new Message("orderTopic", ("orderTopic 001  _"+i).getBytes(StandardCharsets.UTF_8));
            SendResult send = producer.send(message, new MessageQueueSelector() {
                /**
                 *
                 * @param mqs  topic下面的queue
                 * @param msg  外面发送的msg
                 * @param arg  自定义参数
                 * @return
                 */
                @Override
                public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {

                    return mqs.get(0);
                }
            }, null);

            System.out.println("发送成功 " + send);


            Message message1 = new Message("orderTopic", ("orderTopic 001  _"+i).getBytes(StandardCharsets.UTF_8));
            SendResult send1 = producer.send(message1, new MessageQueueSelector() {
                /**
                 *
                 * @param mqs  topic下面的queue
                 * @param msg  外面发送的msg
                 * @param arg  自定义参数
                 * @return
                 */
                @Override
                public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {

                    return mqs.get(2);
                }
            }, null);

            System.out.println("发送成功 " + send1);
        }



    }
}
