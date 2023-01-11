package com.trip.algorithm.leet.some.leet08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xbguo
 * @date 2022/8/16  9:59
 * @description 1656. 设计有序流
 * 1656. 设计有序流
 * 有 n 个 (id, value) 对，其中 id 是 1 到 n 之间的一个整数，value 是一个字符串。不存在 id 相同的两个 (id, value) 对。
 * <p>
 * 设计一个流，以 任意 顺序获取 n 个 (id, value) 对，并在多次调用时 按 id 递增的顺序 返回一些值。
 * <p>
 * 实现 OrderedStream 类：
 * <p>
 * OrderedStream(int n) 构造一个能接收 n 个值的流，并将当前指针 ptr 设为 1 。
 * String[] insert(int id, String value) 向流中存储新的 (id, value) 对。存储后：
 * 如果流存储有 id = ptr 的 (id, value) 对，则找出从 id = ptr 开始的 最长 id 连续递增序列 ，并 按顺序 返回与这些 id 关联的值的列表。然后，将 ptr 更新为最后那个  id + 1 。
 * 否则，返回一个空列表。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入
 * ["OrderedStream", "insert", "insert", "insert", "insert", "insert"]
 * [[5], [3, "ccccc"], [1, "aaaaa"], [2, "bbbbb"], [5, "eeeee"], [4, "ddddd"]]
 * 输出
 * [null, [], ["aaaaa"], ["bbbbb", "ccccc"], [], ["ddddd", "eeeee"]]
 * <p>
 * 解释
 * OrderedStream os= new OrderedStream(5);
 * os.insert(3, "ccccc"); // 插入 (3, "ccccc")，返回 []
 * os.insert(1, "aaaaa"); // 插入 (1, "aaaaa")，返回 ["aaaaa"]
 * os.insert(2, "bbbbb"); // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
 * os.insert(5, "eeeee"); // 插入 (5, "eeeee")，返回 []
 * os.insert(4, "ddddd"); // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 * 1 <= id <= n
 * value.length == 5
 * value 仅由小写字母组成
 * 每次调用 insert 都会使用一个唯一的 id
 * 恰好调用 n 次 insert
 * 通过次数16,779提交次数20,468
 */
public class Solution1656 {
    public static void main(String[] args) {
        OrderedStream stream  =new OrderedStream(5);
        /**
         *  * os.insert(3, "ccccc"); // 插入 (3, "ccccc")，返回 []
         *  * os.insert(1, "aaaaa"); // 插入 (1, "aaaaa")，返回 ["aaaaa"]
         *  * os.insert(2, "bbbbb"); // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
         *  * os.insert(5, "eeeee"); // 插入 (5, "eeeee")，返回 []
         *  * os.insert(4, "ddddd"); // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]
         */
        System.out.println(stream.insert(3,"ccccc"));
        System.out.println(stream.insert(1, "aaaaa"));
        System.out.println(stream.insert(2, "bbbbb"));
        System.out.println(stream.insert(5, "eeeee"));
        System.out.println(stream.insert(4, "ddddd"));

    }

  static   class OrderedStream {
        int ptr = 1;
        int sum;
        Map<Integer, String> map;

        public OrderedStream(int n) {
            sum = n;
            map = new HashMap<>();
        }

        public List<String> insert(int idKey, String value) {
            map.put(idKey, value);
            List<String> list = new ArrayList<>();
            String s = map.get(ptr);
            while (s != null) {
                list.add(s);
                ptr++;
                s = map.get(ptr);
            }
            return list;
        }
    }
}
