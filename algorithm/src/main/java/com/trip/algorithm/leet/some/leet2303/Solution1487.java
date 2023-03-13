package com.trip.algorithm.leet.some.leet2303;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author xbguo
 * @date 2023/3/3 09:29
 * @description Solution1487
 * 1487. 保证文件名唯一
 * 给你一个长度为 n 的字符串数组 names 。你将会在文件系统中创建 n 个文件夹：在第 i 分钟，新建名为 names[i] 的文件夹。
 * <p>
 * 由于两个文件 不能 共享相同的文件名，因此如果新建文件夹使用的文件名已经被占用，系统会以 (k) 的形式为新文件夹的文件名添加后缀，其中 k 是能保证文件名唯一的 最小正整数 。
 * <p>
 * 返回长度为 n 的字符串数组，其中 ans[i] 是创建第 i 个文件夹时系统分配给该文件夹的实际名称。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：names = ["pes","fifa","gta","pes(2019)"]
 * 输出：["pes","fifa","gta","pes(2019)"]
 * 解释：文件系统将会这样创建文件名：
 * "pes" --> 之前未分配，仍为 "pes"
 * "fifa" --> 之前未分配，仍为 "fifa"
 * "gta" --> 之前未分配，仍为 "gta"
 * "pes(2019)" --> 之前未分配，仍为 "pes(2019)"
 * 示例 2：
 * <p>
 * 输入：names = ["gta","gta(1)","gta","avalon"]
 * 输出：["gta","gta(1)","gta(2)","avalon"]
 * 解释：文件系统将会这样创建文件名：
 * "gta" --> 之前未分配，仍为 "gta"
 * "gta(1)" --> 之前未分配，仍为 "gta(1)"
 * "gta" --> 文件名被占用，系统为该名称添加后缀 (k)，由于 "gta(1)" 也被占用，所以 k = 2 。实际创建的文件名为 "gta(2)" 。
 * "avalon" --> 之前未分配，仍为 "avalon"
 * 示例 3：
 * <p>
 * 输入：names = ["onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"]
 * 输出：["onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece(4)"]
 * 解释：当创建最后一个文件夹时，最小的正有效 k 为 4 ，文件名变为 "onepiece(4)"。
 * 示例 4：
 * <p>
 * 输入：names = ["wano","wano","wano","wano"]
 * 输出：["wano","wano(1)","wano(2)","wano(3)"]
 * 解释：每次创建文件夹 "wano" 时，只需增加后缀中 k 的值即可。
 * 示例 5：
 * <p>
 * 输入：names = ["kaido","kaido(1)","kaido","kaido(1)"]
 * 输出：["kaido","kaido(1)","kaido(2)","kaido(1)(1)"]
 * 解释：注意，如果含后缀文件名被占用，那么系统也会按规则在名称后添加新的后缀 (k) 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= names.length <= 5 * 10^4
 * 1 <= names[i].length <= 20
 * names[i] 由小写英文字母、数字和/或圆括号组成。
 */
public class Solution1487 {
    public static void main(String[] args) {
        //String[] names = {"pes", "fifa", "gta", "pes(2019)"};
        //   String[] names = {"gta","gta(1)","gta","avalon"};
        String[] names = {"kaido", "kaido(1)", "kaido", "kaido(1)", "kaido(2)"};
        // String[] names = {"d(2)(4)", "n", "y", "q(3)", "q(3)", "p(2)", "o", "k(4)", "x(1)", "m(1)", "a(2)", "z", "p(2)(3)", "d", "g", "t", "n", "z(3)", "a", "d(2)", "b", "t", "m", "r(1)(2)", "k", "c", "p(2)(1)", "c", "l(1)", "l", "b", "u", "o", "h(2)", "p(3)(3)", "d", "o", "c", "c", "v", "a", "g", "j", "m", "g(4)", "h", "b(2)", "r(3)", "e", "b(1)", "f(4)", "i", "m", "r", "m", "w(3)(4)", "p", "a", "g", "b", "s", "r", "b(1)", "f", "k", "q", "p"};
        //  String[] names = {"wano","wano","wano","wano"};
        // String[] names = {"kaido", "kaido(1)", "kaido", "kaido(1)"};
        String[] folderNames = getFolderNames(names);
        System.out.println(Arrays.toString(folderNames));
    }


    public String[] getFolderNames1(String[] names) {
        Map<String, Integer> index = new HashMap<String, Integer>();
        int n = names.length;
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            String name = names[i];
            if (!index.containsKey(name)) {
                res[i] = name;
                index.put(name, 1);
            } else {
                int k = index.get(name);
                while (index.containsKey(addSuffix(name, k))) {
                    k++;
                }
                res[i] = addSuffix(name, k);
                index.put(name, k + 1);
                index.put(addSuffix(name, k), 1);
            }
        }
        return res;
    }

    public String addSuffix(String name, int k) {
        return name + "(" + k + ")";
    }


    public static String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[] res = new String[names.length];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (map.containsKey(name)) {
                Integer size = map.get(name);
                name = name + "(" + size + ")";
                while (!set.add(name)) {
                    size++;
                    name = names[i] + "(" + size + ")";
                }
                res[i] = name;
                map.put(name, 1);
            } else {
                res[i] = name;
                map.put(name, 1);
                set.add(name);
            }
        }
        return res;
    }
}
