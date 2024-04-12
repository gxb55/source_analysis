package com.trip.algorithm.leet.l24.l04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xbguo
 * @date 2024/4/7 18:36
 */
public class Solution1600 {
    public static void main(String[] args) {
        /**
         * ["ThroneInheritance", "birth", "birth", "birth", "birth", "birth", "birth", "getInheritanceOrder", "death", "getInheritanceOrder"]
         * [["king"], ["king", "andy"], ["king", "bob"], ["king", "catherine"], ["andy", "matthew"], ["bob", "alex"], ["bob", "asha"], [null], ["bob"], [null]]
         */
        String king = "king";
        ThroneInheritance throneInheritance = new ThroneInheritance(king);
        throneInheritance.birth("king", "andy");
        throneInheritance.birth("king", "bob");
        throneInheritance.birth("king", "catherine");
        throneInheritance.birth("andy", "matthew");
        throneInheritance.birth("bob", "alex");
        throneInheritance.birth("bob", "asha");
        System.out.println(throneInheritance.getInheritanceOrder());
        throneInheritance.death("bob");
        System.out.println(throneInheritance.getInheritanceOrder());
    }
}

class ThroneInheritance {
    Map<String, List<String>> map = new HashMap<>();
    Map<String, String> parentMap = new HashMap<>();
    List<String> dealList = new ArrayList<>();
    String kingName;
    List<String> list = new ArrayList<>();

    public ThroneInheritance(String kingName) {
        this.kingName = kingName;
    }

    public void birth(String parentName, String childName) {
        List<String> orDefault = map.getOrDefault(parentName, new ArrayList<>());
        orDefault.add(childName);
        map.put(parentName, orDefault);
        parentMap.put(childName, parentName);
        if (!list.isEmpty()) {
            if (orDefault.size() == 1) {
                int i = list.indexOf(parentName);
                list.add(i, childName);
            } else {
                int i = list.indexOf(orDefault.get(orDefault.size() - 2));
                list.add(i, childName);
            }
        }

    }

    public void death(String name) {
        dealList.add(name);
    }

    public List<String> getInheritanceOrder() {
        if (list.isEmpty()) {
            process(list, kingName);
            ArrayList<String> strings = new ArrayList<>(list);
            strings.removeAll(dealList);
            return strings;
        }
        ArrayList<String> strings = new ArrayList<>(list);
        strings.removeAll(dealList);
        return strings;
    }

    /**
     * Successor(x, curOrder):
     * 如果 x 没有孩子或者所有 x 的孩子都在 curOrder 中：
     * 如果 x 是国王，那么返回 null
     * 否则，返回 Successor(x 的父亲, curOrder)
     * 否则，返回 x 不在 curOrder 中最年长的孩子
     *
     * @param list
     * @param curName
     */
    private void process(List<String> list, String curName) {
        if (!list.contains(curName)) {
            list.add(curName);
        }
        List<String> list1 = map.get(curName);

        if (list1 == null || list1.stream().allMatch(x -> list.contains(x))) {
            if (curName.equals(kingName)) {
                return;
            }
            process(list, parentMap.get(curName));
            return;
        }
        for (String t : list1) {
            if (!list.contains(t)) {
                process(list, t);
            }
        }
    }
}