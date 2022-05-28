/**
 * DefaultMQPushConsumer 消费消息
 * 1.设置nameServer
 * 2.指定topic 和过滤条件
 * 3.指定消费的消费器，是同步的顺序的还是异步的
 *
 *
 * 源码进入
 * org.apache.rocketmq.client.impl.consumer.DefaultMQPushConsumerImpl#start()
 *      org.apache.rocketmq.client.impl.consumer.DefaultMQPushConsumerImpl#checkConfig() 检查各种配置，线程数，topic，消费组等等等等
 *      org.apache.rocketmq.client.impl.consumer.DefaultMQPushConsumerImpl#mQClientFactory 链接namespace的工厂
 *      org.apache.rocketmq.client.impl.consumer.DefaultMQPushConsumerImpl#rebalanceImpl 消息重新消费的策略以及具体内容
 *      org.apache.rocketmq.client.impl.consumer.DefaultMQPushConsumerImpl#pullAPIWrapper 拉取消息的包装器 重要，消息都是通过他来拉取，然后根据消费的实现来消费看是顺序还是异步
 *      org.apache.rocketmq.client.impl.consumer.DefaultMQPushConsumerImpl#offsetStore 存储消息消费到哪里了，集群模式消息消费的位置由broker决定，广播模式由consumer自己维护 org.apache.rocketmq.common.protocol.heartbeat.MessageModel
 *      org.apache.rocketmq.client.impl.consumer.DefaultMQPushConsumerImpl#getMessageListenerInner() 具体看是哪种消费模式 重要  org.apache.rocketmq.client.consumer.listener.MessageListener
 *      org.apache.rocketmq.client.impl.consumer.ConsumeMessageService#start() 具体的消费模式启动 重要
 *      org.apache.rocketmq.client.impl.factory.MQClientInstance#start() 链接工程链接nameserver成功，然后启动  重要
 *
 *
 *
 * 拉消息的
 *org.apache.rocketmq.client.impl.consumer.DefaultMQPushConsumerImpl#pullMessage(org.apache.rocketmq.client.impl.consumer.PullRequest)
 *
 * org.apache.rocketmq.client.impl.consumer.ConsumeMessageService 消费的接口
 * org.apache.rocketmq.client.impl.consumer.ConsumeMessageConcurrentlyService  并发消费
 *
 * org.apache.rocketmq.client.impl.consumer.ConsumeMessageOrderlyService 顺序消费
 *
 *
 *
 * org.apache.rocketmq.client.consumer.DefaultMQPushConsumer 消费消息的
 * org.apache.rocketmq.client.impl.consumer.DefaultMQPushConsumerImpl 主要逻辑，上面的哪个类调用当前类去执行具体的业务逻辑
 * org.apache.rocketmq.client.impl.consumer.DefaultMQPushConsumerImpl#pullMessage(org.apache.rocketmq.client.impl.consumer.PullRequest) 消费消息的主要逻辑
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * org.apache.rocketmq.client.impl.consumer.ProcessQueue 消息
 *
 */
package com.trip.study.rocket;