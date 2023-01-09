package com.trip.algorithm.leet.some.leet2301;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/1/5 09:53
 * @description 1803
 * 输入：nums = [1,4,2,7], low = 2, high = 6
 * 输出：6
 * 解释：所有漂亮数对 (i, j) 列出如下：
 * - (0, 1): nums[0] XOR nums[1] = 5
 * - (0, 2): nums[0] XOR nums[2] = 3
 * - (0, 3): nums[0] XOR nums[3] = 6
 * - (1, 2): nums[1] XOR nums[2] = 6
 * - (1, 3): nums[1] XOR nums[3] = 3
 * - (2, 3): nums[2] XOR nums[3] = 5
 * 示例 2：
 * <p>
 * 输入：nums = [9,8,4,2,1], low = 5, high = 14
 * 输出：8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-pairs-with-xor-in-a-range
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1803 {
    public static void main(String[] args) {
        Solution1803 solution1803 = new Solution1803();
      /*  int[] nums = {1, 4, 2, 7};
        int low = 2, high = 6; */

        int[] nums = {9, 8, 4, 2, 1};
        int low = 5, high = 14;
        int i = solution1803.countPairs(nums, low, high);
        System.out.println(i);

    }

    public int countPairs(int[] nums, int low, int high) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int val = nums[i] ^ nums[j];
                if (val >= low && val <= high) {
                    res++;
                }
            }
        }
        return res;
    }

    // 字典树的根节点
    private Trie root = null;
    // 最高位的二进制位编号为 14
    private static final int HIGH_BIT = 14;

    public int countPairs1(int[] nums, int low, int high) {
        return f(nums, high) - f(nums, low - 1);
    }

    public int f(int[] nums, int x) {
        root = new Trie();
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            add(nums[i - 1]);
            res += get(nums[i], x);
        }
        return res;
    }

    public void add(int num) {
        Trie cur = root;
        for (int k = HIGH_BIT; k >= 0; k--) {
            int bit = (num >> k) & 1;
            if (cur.son[bit] == null) {
                cur.son[bit] = new Trie();
            }
            cur = cur.son[bit];
            cur.sum++;
        }
    }

    //如果是同值取0、异值取1。
    public int get(int num, int x) {
        Trie cur = root;
        int sum = 0;
        for (int k = HIGH_BIT; k >= 0; k--) {
            int r = (num >> k) & 1;
            if (((x >> k) & 1) != 0) {
                if (cur.son[r] != null) {
                    sum += cur.son[r].sum;
                }
                if (cur.son[r ^ 1] == null) {
                    return sum;
                }
                cur = cur.son[r ^ 1];
            } else {
                if (cur.son[r] == null) {
                    return sum;
                }
                cur = cur.son[r];
            }
        }
        sum += cur.sum;
        return sum;
    }


    static Map<Integer, Integer> map = new HashMap<>();

    int get(int cur) {
        if (map.containsKey(cur)) {
            return map.get(cur);
        }
        int ans = 0;
        for (int i = cur; i > 0; i -= lowbit(i)) {
            ans++;
        }
        map.put(cur, ans);
        return ans;
    }

    int lowbit(int x) {
        return x & -x;
    }

    int n;
    int ans = Integer.MIN_VALUE;
    int[] hash;

    public int maxLength(List<String> _ws) {
        n = _ws.size();
        HashSet<Integer> set = new HashSet<>();
        for (String s : _ws) {
            int val = 0;
            for (char c : s.toCharArray()) {
                int t = (int) (c - 'a');
                if (((val >> t) & 1) != 0) {
                    val = -1;
                    break;
                }
                val |= (1 << t);
            }
            if (val != -1) {
                set.add(val);
            }
        }

        n = set.size();
        if (n == 0) {
            return 0;
        }
        hash = new int[n];

        int idx = 0;
        int total = 0;
        for (Integer i : set) {
            hash[idx++] = i;
            total |= i;
        }
        dfs(0, 0, total);
        return ans;
    }

    void dfs(int u, int cur, int total) {
        if (get(cur | total) <= ans) {
            return;
        }
        if (u == n) {
            ans = Math.max(ans, get(cur));
            return;
        }
        // 在原有基础上，选择该数字（如果可以）
        if ((hash[u] & cur) == 0) {
            dfs(u + 1, hash[u] | cur, total - (total & hash[u]));
        }
        // 不选择该数字
        dfs(u + 1, cur, total);
    }
}


class Trie {
    // son[0] 表示左子树，son[1] 表示右子树
    Trie[] son = new Trie[2];
    int sum;

    public Trie() {
        sum = 0;
    }
}