package com.trip.study.rocket.transaction;

import com.trip.study.rocket.simple.MQConstant;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

import java.nio.charset.StandardCharsets;

/**
 * @author Administrator
 */
public class ProducerTransaction {
    public static void main(String[] args) throws Exception {
        TransactionMQProducer producer = new TransactionMQProducer("transaction");

        producer.setNamesrvAddr(MQConstant.NAMESPACE);
        producer.setTransactionListener(new TransactionListener() {
            //事务消息执行
            @Override
            public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
                System.out.println("executeLocalTransaction ,msg:"+msg);
                return LocalTransactionState.UNKNOW;
            }
            // broker回调 问事务消息是否执行成功
            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt msg) {
                System.out.println("checkLocalTransaction ,msg:"+msg);
                return LocalTransactionState.COMMIT_MESSAGE;
            }
        });

        producer.start();
        Message message = new Message("Topic_transaction","事务消息测试第一条".getBytes(StandardCharsets.UTF_8));
        SendResult send = producer.sendMessageInTransaction(message,null);
        System.out.println(send);
        System.out.println("事务消息客户端启动完毕");
    }
}
