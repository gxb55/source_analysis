package com.trip.algorithm.leet.l24.l100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution76 {
    public static void main(String[] args) {
      //  String s = "ADOBECODEBANC", t = "ABC";
       // String s = "A", t = "A";
        String s = "cabwefgewcwaefgcf", t = "cae";
        String string = minWindow(s, t);
        System.out.println(string);
    }

    public static String minWindow(String s, String t) {
        List<MyCharacter> list = new ArrayList<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            String c = charArray[i] + "";
            if (t.contains(c)) {
                list.add(new MyCharacter(i, charArray[i]));
            }
        }
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> resultMap = new HashMap<>();
        char[] charArray1 = t.toCharArray();
        for (Character c : charArray1) {
            resultMap.put(c, resultMap.getOrDefault(c, 0) + 1);
        }
        List<int[]> li = new ArrayList<>();
        int left = 0;
        for (int i = 0; i < list.size(); i++) {
            MyCharacter myCharacter = list.get(i);
            map.put(myCharacter.character, map.getOrDefault(myCharacter.character, 0) + 1);
            boolean b = resultMap.entrySet().stream().allMatch(x -> {
                Integer i1 = map.get(x.getKey());
                if (i1 == null) {
                    return false;
                }
                return i1 >= x.getValue();
            });
            while (b) {
                // 左边
                MyCharacter myCharacter1 = list.get(left);
                li.add(new int[]{myCharacter1.index, myCharacter.index});

                map.put(myCharacter1.character, map.getOrDefault(myCharacter1.character, 0) - 1);
                left++;
                b = resultMap.entrySet().stream().allMatch(x -> {
                    Integer i1 = map.get(x.getKey());
                    if (i1 == null) {
                        return false;
                    }
                    return i1 >= x.getValue();
                });
            }
        }
        while (left < list.size()) {
            boolean b = resultMap.entrySet().stream().allMatch(x -> {
                Integer i1 = map.get(x.getKey());
                if (i1 == null) {
                    return false;
                }
                return i1 >= x.getValue();
            });
            if (b) {
                MyCharacter myCharacter1 = list.get(left);
                li.add(new int[]{myCharacter1.index, list.get(list.size() - 1).index});
                map.put(myCharacter1.character, map.getOrDefault(myCharacter1.character, 0) - 1);
                left++;
            }else {
                break;
            }

        }
        if (li.isEmpty()) {
            return "";
        }
        int[] ints = li.stream().sorted((x, y) -> (x[1] - x[0]) - (y[1] - y[0])).findFirst().get();
        String string = new String();
        for (int i = ints[0]; i <= ints[1]; i++) {
            string = string + charArray[i];
        }
        return string;
    }
}

class MyCharacter {
    int index;
    Character character;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public MyCharacter(int index, Character character) {
        this.index = index;
        this.character = character;
    }

    public MyCharacter() {
    }
}