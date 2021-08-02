package com.trip.algorithm.zuo.day0703;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;


/**
 * @author Administrator
 * 自定义堆结构  heap
 * 可以改变栈中的元素然后重新排列依赖于map<node,Integer>
 */
public class Code02_Heap02 {
    public static void main(String[] args) {
        Student student = new Student(1, 1);
        Student student1 = new Student(2, 2);
        Student student2 = new Student(3, 3);
        Student student3 = new Student(4, 4);
        MyHeap myHeap = new MyHeap<Student>((o1, o2) -> {
            //返回负数的时候，第一个参数排在前面  升序
            return o1.studentNo - o2.studentNo;
        });
        myHeap.push(student);
        myHeap.push(student1);
        myHeap.push(student2);
        myHeap.push(student3);

        student1.setStudentNo(5);
        student1.setAge(5);
        myHeap.resign(student1);
        while (!myHeap.isEmpty()) {
            System.out.println(myHeap.pop());
        }
    }

    public static class MyHeap<T> {
        private ArrayList<T> heap;
        private HashMap<T, Integer> indexMap;
        private int heapSize;
        private Comparator<? super T> comparator;

        public MyHeap(Comparator<? super T> comparator) {
            this.comparator = comparator;
            heap = new ArrayList<>();
            indexMap = new HashMap<>();
            heapSize = 0;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public Integer length() {
            return heapSize;
        }

        public boolean contains(T t) {
            return indexMap.containsKey(t);
        }

        public void push(T t) {
            heap.add(t);
            indexMap.put(t, heapSize);
            heapInsert(heapSize++);
        }

        public T pop() {
            T t = heap.get(0);
            int n = heapSize;
            swap(0, n - 1);
            heap.remove(t);
            indexMap.remove(t);
            heapify(0, --heapSize);
            return t;
        }

        private void heapify(int index, int heapSize) {
            int left = index * 2 + 1;
            while (left < heapSize) {
                int max = left + 1 < heapSize && comparator.compare(heap.get(left+1), heap.get(left )) > 0 ? left +1: left ;
                if (comparator.compare(heap.get(max), heap.get(index)) <= 0) {
                    break;
                }
                swap(index, max);
                index = max;
                left = index * 2 + 1;
            }
        }

        private void heapInsert(int index) {
            int parent = (index - 1) / 2;
            while (parent >= 0) {
                if (comparator.compare(heap.get(parent), heap.get(index)) >= 0) {
                    break;
                }
                swap(parent, index);
                index = parent;
                parent = (index - 1) / 2;
            }
        }

        public void resign(T value) {
            Integer index = indexMap.get(value);
            heapInsert(index);
            heapify(index, heapSize);
        }

        private void swap(int parent, int index) {
            T parentNode = heap.get(parent);
            T indexNode = heap.get(index);
            indexMap.put(parentNode, index);
            indexMap.put(indexNode, parent);
            heap.remove(parentNode);
            heap.remove(indexNode);
            heap.add(parent, indexNode);
            heap.add(index, parentNode);
        }
    }

    @Getter
    @Setter
    static class Student {
        private int age;
        private int studentNo;

        public Student(int age, int studentNo) {
            this.age = age;
            this.studentNo = studentNo;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", studentNo=" + studentNo +
                    '}';
        }
/**
 * -1就交换
 * 降序
 * @param o1
 * @param o2
 * @return
 */

    }

}
