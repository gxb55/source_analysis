/**
 * 集合不安全
 * list
 * set
 * Hashmap
 *
 * 主要是因为在遍历元素的时候不能往里面加入元素，java.util.ConcurrentModificationException
 * 在遍历前都确定了元素的数量，遍历的时候加入元素就会报错
 */
package com.trip.study.juc.collector;