package com.trip.algorithm.leet.some.leet2311;

/**
 * @author xbguo
 * @date 2023/11/24 16:10
 *
 * HTML 里这些特殊字符和它们对应的字符实体包括：
 *
 * 双引号：字符实体为 &quot; ，对应的字符是 " 。
 * 单引号：字符实体为 &apos; ，对应的字符是 ' 。
 * 与符号：字符实体为 &amp; ，对应对的字符是 & 。
 * 大于号：字符实体为 &gt; ，对应的字符是 > 。
 * 小于号：字符实体为 &lt; ，对应的字符是 < 。
 * 斜线号：字符实体为 &frasl; ，对应的字符是 / 。
 */
public class Solution1410 {
    public static void main(String[] args) {

    }

    public String entityParser(String text) {
        String s = text.replaceAll("&quot;", "\"")
                .replaceAll("&apos;", "'")

                .replaceAll("&gt;", ">")
                .replaceAll("&lt;", "<")
                .replaceAll("&frasl;", "/")
                .replaceAll("&amp;", "&");
        return s;
    }
}
