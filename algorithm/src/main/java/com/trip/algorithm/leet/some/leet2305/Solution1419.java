package com.trip.algorithm.leet.some.leet2305;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/5/6 10:09
 * 1419. 数青蛙
 * 给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。由于同一时间可以有多只青蛙呱呱作响，所以 croakOfFrogs 中会混合多个 “croak” 。
 * <p>
 * 请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
 * <p>
 * 要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。如果没有输出全部五个字母，那么它就不会发出声音。如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：croakOfFrogs = "croakcroak"
 * 输出：1
 * 解释：一只青蛙 “呱呱” 两次
 * 示例 2：
 * <p>
 * 输入：croakOfFrogs = "crcoakroak"
 * 输出：2
 * 解释：最少需要两只青蛙，“呱呱” 声用黑体标注
 * 第一只青蛙 "crcoakroak"
 * 第二只青蛙 "crcoakroak"
 * 示例 3：
 * <p>
 * 输入：croakOfFrogs = "croakcrook"
 * 输出：-1
 * 解释：给出的字符串不是 "croak" 的有效组合。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= croakOfFrogs.length <= 105
 * 字符串中的字符只有 'c', 'r', 'o', 'a' 或者 'k'
 * 通过次数15,394提交次数33,179
 */
public class Solution1419 {
    public static void main(String[] args) {
        String croakOfFrogs = "croakcroak";
        croakOfFrogs = "crcoakroak";
        croakOfFrogs = "ccrcroakorakoak";
        croakOfFrogs = "croakcroakccrcroakorakoakcroakcroak";
        croakOfFrogs = "crocakcroraoakk";
        croakOfFrogs = "ccccccccccrrccccccrcccccccccccrcccccccccrcccccccccccrcccccrcccrrcccccccccccccrocrrcccccccccrccrocccccrccccrrcccccccrrrcrrcrccrcoccroccrccccccccorocrocccrrrrcrccrcrcrcrccrcroccccrccccroorcacrkcccrrroacccrrrraocccrrcrrccorooccrocacckcrcrrrrrrkrrccrcoacrcorcrooccacorcrccccoocroacroraoaarcoorrcrcccccocrrcoccarrorccccrcraoocrrrcoaoroccooccororrrccrcrocrrcorooocorarccoccocrrrocaccrooaaarrcrarooaarrarrororrcrcckracaccorarorocacrrarorrraoacrcokcarcoccoorcrrkaocorcrcrcrooorrcrroorkkaaarkraroraraarooccrkcrcraocooaoocraoorrrccoaraocoorrcokrararrkaakaooroorcororcaorckrrooooakcarokokcoarcccroaakkrrororacrkraooacrkaraoacaraorrorrakaokrokraccaockrookrokoororoooorroaoaokccraoraraokakrookkroakkaookkooraaocakrkokoraoarrakakkakaroaaocakkarkoocokokkrcorkkoorrkraoorkokkarkakokkkracocoaaaaakaraaooraokarrakkorokkoakokakakkcracarcaoaaoaoorcaakkraooaoakkrrroaoaoaarkkarkarkrooaookkroaaarkooakarakkooaokkoorkroaaaokoarkorraoraorcokokaakkaakrkaaokaaaroarkokokkokkkoakaaookkcakkrakooaooroaaaaooaooorkakrkkakkkkaokkooaakorkaroaorkkokaakaaaaaocrrkakrooaaroroakrakrkrakaoaaakokkaaoakrkkoakocaookkakooorkakoaaaaakkokakkorakaaaaoaarkokorkakokakckckookkraooaakokrrakkrkookkaaoakaaaokkaokkaaoakarkakaakkakorkaakkakkkakaaoaakkkaoaokkkakkkoaroookakaokaakkkkkkakoaooakcokkkrrokkkkaoakckakokkocaokaakakaaakakaakakkkkrakoaokkaakkkkkokkkkkkkkrkakkokkroaakkakaoakkoakkkkkkakakakkkaakkkkakkkrkoak";
        int i = minNumberOfFrogs(croakOfFrogs);
        System.out.println(i);
    }

    public static int minNumberOfFrogs(String croakOfFrogs) {
        int length = croakOfFrogs.length();
        if (length % 5 != 0) {
            return -1;
        }
        String str = "croak";
        while (croakOfFrogs.startsWith(str)) {
            croakOfFrogs = croakOfFrogs.substring(5);
        }
        while (croakOfFrogs.endsWith(str)) {
            croakOfFrogs = croakOfFrogs.substring(0, croakOfFrogs.length() - 5);
        }
        if (croakOfFrogs.length() == 0) {
            return 1;
        }
        int res = croakOfFrogs.length() / 5;
        String s = "";
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            s = s + "X";
        }
        List<int[]> list = new ArrayList<>();
        int count = 0;
        while (!croakOfFrogs.equals(s)) {
            StringBuilder stringBuilder = new StringBuilder();
            int index = 0;
            int first = -1;
            int end = -1;
            for (int i = 0; i < croakOfFrogs.length(); i++) {
                if (index < str.length() && croakOfFrogs.charAt(i) == str.charAt(index)) {
                    if (index == 0) {
                        first = i;
                    } else if (index == 4) {
                        end = i;
                    }
                    index++;
                    stringBuilder.append("X");
                } else {
                    stringBuilder.append(croakOfFrogs.charAt(i));
                }
            }
            if (index != str.length()) {
                return -1;
            }
            int finalFirst = first;
            boolean b = list.stream().anyMatch(x -> {
                int y1 = x[1];
                return finalFirst > y1;
            });
            if (!b) {
                count++;
            }
            list.add(new int[]{first, end});
            croakOfFrogs = stringBuilder.toString();
        }
        return count;
    }
}
