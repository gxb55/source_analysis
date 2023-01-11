package com.trip.algorithm.leet.some.leet08;

import java.util.LinkedList;

/**
 * @author xbguo
 * @date 2022/8/15  11:31
 * @description Solution641
 * 641. 设计循环双端队列
 * 设计实现双端队列。
 * <p>
 * 实现 MyCircularDeque 类:
 * <p>
 * MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。
 * boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。
 * boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
 * boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。
 * boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
 * int getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
 * int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
 * boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false  。
 * boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入
 * ["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
 * [[3], [1], [2], [3], [4], [], [], [], [4], []]
 * 输出
 * [null, true, true, true, false, 2, true, true, true, 4]
 * <p>
 * 解释
 * MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
 * circularDeque.insertLast(1);			        // 返回 true
 * circularDeque.insertLast(2);			        // 返回 true
 * circularDeque.insertFront(3);			        // 返回 true
 * circularDeque.insertFront(4);			        // 已经满了，返回 false
 * circularDeque.getRear();  				// 返回 2
 * circularDeque.isFull();				        // 返回 true
 * circularDeque.deleteLast();			        // 返回 true
 * circularDeque.insertFront(4);			        // 返回 true
 * circularDeque.getFront();				// 返回 4
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= 1000
 * 0 <= value <= 1000
 * insertFront, insertLast, deleteFront, deleteLast, getFront, getRear, isEmpty, isFull  调用次数不大于 2000 次
 * 通过次数38,402提交次数68,987
 */
public class Solution641 {
    public static void main(String[] args) {
        MyCircularDeque2 myCircularDeque = new MyCircularDeque2(3);
        myCircularDeque.insertLast(1);
        myCircularDeque.insertLast(2);
        myCircularDeque.insertFront(3);
        System.out.println(myCircularDeque.insertFront(4));
        System.out.println(myCircularDeque.getRear());
        System.out.println(myCircularDeque.isFull());
        System.out.println(myCircularDeque.deleteLast());
        System.out.println(myCircularDeque.insertFront(4));
        System.out.println(myCircularDeque.getFront());
    }

    static class MyCircularDeque1 {

        // 1、不用设计成动态数组，使用静态数组即可
        // 2、设计 head 和 tail 指针变量
        // 3、head == tail 成立的时候表示队列为空
        // 4、tail + 1 == head

        private int capacity;
        private int[] arr;
        private int front;
        private int rear;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque1(int k) {
            capacity = k + 1;
            arr = new int[capacity];

            // 头部指向第 1 个存放元素的位置
            // 插入时，先减，再赋值
            // 删除时，索引 +1（注意取模）
            front = 0;
            // 尾部指向下一个插入元素的位置
            // 插入时，先赋值，再加
            // 删除时，索引 -1（注意取模）
            rear = 0;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            front = (front - 1 + capacity) % capacity;
            arr[front] = value;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            arr[rear] = value;
            rear = (rear + 1) % capacity;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            // front 被设计在数组的开头，所以是 +1
            front = (front + 1) % capacity;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            // rear 被设计在数组的末尾，所以是 -1
            rear = (rear - 1 + capacity) % capacity;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return arr[front];
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            // 当 rear 为 0 时防止数组越界
            return arr[(rear - 1 + capacity) % capacity];
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return front == rear;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            // 注意：这个设计是非常经典的做法
            return (rear + 1) % capacity == front;
        }
    }

    static class MyCircularDeque {
        LinkedList<Integer> list = new LinkedList<>();
        int size;

        public MyCircularDeque(int k) {
            size = k;
        }

        public boolean insertFront(int value) {
            if (list.size() >= size) {
                return false;
            }
            list.addFirst(value);
            return true;
        }

        public boolean insertLast(int value) {
            if (list.size() >= size) {
                return false;
            }
            list.addLast(value);
            return true;
        }

        public boolean deleteFront() {
            if (list.isEmpty()) {
                return false;
            }
            list.removeFirst();
            return true;
        }

        public boolean deleteLast() {
            if (list.isEmpty()) {
                return false;
            }
            list.removeLast();
            return true;
        }

        public int getFront() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.getFirst();
        }

        public int getRear() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.getLast();
        }

        public boolean isEmpty() {

            return list.isEmpty();
        }

        public boolean isFull() {
            return list.size() == size;
        }
    }

    static class MyCircularDeque2 {

        // 1、不用设计成动态数组，使用静态数组即可
        // 2、设计 head 和 tail 指针变量
        // 3、head == tail 成立的时候表示队列为空
        // 4、tail + 1 == head

        private int capacity;
        private int[] arr;
        // 计算之后使用，当前值是已经使用了
        private int front;
        // 直接使用，当前值是计算好了，还未使用
        private int rear;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque2(int k) {
            front = 0;
            rear = 0;
            arr = new int[k + 1];
            capacity = k + 1;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            /**
             * 假如长度是6
             * 首位的第一次是 0  5
             *              5  4
             *              4  3
             */
            front = (front - 1 + capacity) % capacity;
            arr[front] = value;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            arr[rear] = value;
            rear = (rear + 1) % capacity;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            front = (front + 1) % capacity;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            rear = (rear - 1 + capacity) % capacity;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return arr[front];
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return arr[(rear-1+capacity)%capacity];
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return front == rear;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return (rear + 1) % capacity == front;
        }
    }
}
