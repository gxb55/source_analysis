/**
 * 事务消息 采用2pc 即两阶段提交
 * 1.producer发送事务消息，消息进入halfMessage队列，这个时候消息还不能被消费
 * 2.producer告知broker消息是否成功还是unknow
 * 3.如果在一定时间内broker没有收到producer的反馈，他会将halfmessage消息里面的消息，进行回调producer，
 * 4.通过回调看是否成功，成功则给consumer消费，不成功则剔除halfmessage
 */
package com.trip.study.rocket.transaction;