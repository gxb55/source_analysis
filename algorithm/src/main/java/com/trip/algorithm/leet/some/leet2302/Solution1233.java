package com.trip.algorithm.leet.some.leet2302;

import java.util.*;

/**
 * @author xbguo
 * @date 2023/2/8 10:06
 * 输入：folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
 * 输出：["/a","/c/d","/c/f"]
 * 解释："/a/b" 是 "/a" 的子文件夹，而 "/c/d/e" 是 "/c/d" 的子文件夹。
 * 示例 2：
 * <p>
 * 输入：folder = ["/a","/a/b/c","/a/b/d"]
 * 输出：["/a"]
 * 解释：文件夹 "/a/b/c" 和 "/a/b/d" 都会被删除，因为它们都是 "/a" 的子文件夹。
 * 示例 3：
 * <p>
 * 输入: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
 * 输出: ["/a/b/c","/a/b/ca","/a/b/d"]
 */
public class Solution1233 {
    public static void main(String[] args) {
        Solution1233 solution1233 = new Solution1233();
      //  String[] arr = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
     //   String[] arr = {"/a","/a/b/c","/a/b/d"};
      //  String[] arr = {"/a/b/c","/a/b/ca","/a/b/d"};
        String[] arr = {"/ah/al/am","/ah/al"};
        List<String> list = solution1233.removeSubfolders(arr);
        System.out.println(list);
    }

    public List<String> removeSubfolders(String[] folder) {
        Map<String, Node1> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        Arrays.sort(folder, Comparator.comparingInt(String::length));
        for (int i = 0; i < folder.length; i++) {
            String cur = folder[i].substring(1);
            buildNode(map, cur.split("/"), list);
        }
        return list;
    }

    private void buildNode(Map<String, Node1> map, String[] toCharArray, List<String> list) {
        Node1 lastNode = null;
        StringBuilder stringBuilder = new StringBuilder();
        int i = 1;
        for (int j = 0; j < toCharArray.length; j++) {
            String s =toCharArray[j];
            stringBuilder.append("/").append(s);
            boolean flag = j == toCharArray.length - 1 ? true : false;
            if (j == 0) {
                Node1 nodeCur = map.get(s);
                if (nodeCur == null) {
                    nodeCur = new Node1(s, flag);
                    map.put(s, nodeCur);
                }
                lastNode = nodeCur;
            } else {
                Node1 nodeCur = lastNode.map.get(s);
                if (nodeCur == null) {
                    nodeCur = new Node1(s, flag);
                    lastNode.map.put(s, nodeCur);
                }
                lastNode = nodeCur;
            }

            if (lastNode.endFlag && i == 1) {
                if(list.contains(stringBuilder.toString())){
                    i++;
                }
                if(i==1){
                    list.add(stringBuilder.toString());
                }
                i++;

            }
        }

    }


    static class Node1 {
        private String rootName;
        private boolean endFlag;
        private Map<String, Node1> map;

        public Node1(String rootName, boolean endFlag) {
            this.rootName = rootName;
            this.endFlag = endFlag;
            this.map = new HashMap();
        }
    }
}
