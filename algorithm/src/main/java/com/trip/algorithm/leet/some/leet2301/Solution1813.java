package com.trip.algorithm.leet.some.leet2301;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2023年01月16日 08:21:00
 * 1813. 句子相似性 III
 * 一个句子是由一些单词与它们之间的单个空格组成，且句子的开头和结尾没有多余空格。比方说，"Hello World" ，"HELLO" ，"hello world hello world" 都是句子。每个单词都 只 包含大写和小写英文字母。
 *
 * 如果两个句子 sentence1 和 sentence2 ，可以通过往其中一个句子插入一个任意的句子（可以是空句子）而得到另一个句子，那么我们称这两个句子是 相似的 。比方说，sentence1 = "Hello my name is Jane" 且 sentence2 = "Hello Jane" ，我们可以往 sentence2 中 "Hello" 和 "Jane" 之间插入 "my name is" 得到 sentence1 。
 *
 * 给你两个句子 sentence1 和 sentence2 ，如果 sentence1 和 sentence2 是相似的，请你返回 true ，否则返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：sentence1 = "My name is Haley", sentence2 = "My Haley"
 * 输出：true
 * 解释：可以往 sentence2 中 "My" 和 "Haley" 之间插入 "name is" ，得到 sentence1 。
 * 示例 2：
 *
 * 输入：sentence1 = "of", sentence2 = "A lot of words"
 * 输出：false
 * 解释：没法往这两个句子中的一个句子只插入一个句子就得到另一个句子。
 * 示例 3：
 *
 * 输入：sentence1 = "Eating right now", sentence2 = "Eating"
 * 输出：true
 * 解释：可以往 sentence2 的结尾插入 "right now" 得到 sentence1 。
 * 示例 4：
 *
 * 输入：sentence1 = "Luky", sentence2 = "Lucccky"
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= sentence1.length, sentence2.length <= 100
 * sentence1 和 sentence2 都只包含大小写英文字母和空格。
 * sentence1 和 sentence2 中的单词都只由单个空格隔开。
 * 通过次数9,507提交次数20,864
 */
public class Solution1813 {
    public static void main(String[] args) {
        Solution1813 solution1813 = new Solution1813();
      // String sentence1 = "My name is Haley1", sentence2 = "My Haley";
       // String sentence1 = "of", sentence2 = "A lot of words";
        String sentence1 = "Luky", sentence2 = "Lucccky";
        boolean b = solution1813.areSentencesSimilar(sentence1, sentence2);
        System.out.println(b);
    }

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.length() > sentence2.length()) {
            String str = sentence1;
            sentence1 = sentence2;
            sentence2 = str;
        }
        // 由 sentence1 ->sentence2
        if (sentence2.contains(sentence1)) {
            if (sentence2.startsWith(sentence1 + " ")) {
                return true;
            } else if (sentence2.endsWith(" " + sentence1)) {
                return true;
            }
        }

        LinkedList<String> list1 = Arrays.stream(sentence1.split(" ")).collect(Collectors.toCollection(LinkedList::new));
        LinkedList<String> list2 = Arrays.stream(sentence2.split(" ")).collect(Collectors.toCollection(LinkedList::new));
        while (!list1.isEmpty() && list1.peekFirst().equals(list2.peekFirst())) {
            list1.pollFirst();
            list2.pollFirst();
        }
        while (!list1.isEmpty() && list1.peekLast().equals(list2.peekLast())) {
            list1.pollLast();
            list2.pollLast();
        }
        return list1.isEmpty();
    }
}
