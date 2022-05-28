/**
 * 顺序消息
 * 1.同一个topic 同一个queue才会保证顺序
 * 2.消费的时候注册的监听器要是顺序的，他会保证每个topic的queue是同一个线程消费的
 *
 */
package com.trip.study.rocket.order;