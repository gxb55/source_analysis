package com.trip.algorithm.leet.some.leet2303;

/**
 * @author xbguo
 * @createTime 2023年03月18日 21:41:00
 * 输入：a = "x", b = "y"
 * 输出：true
 * 解释：如果 a 或者 b 是回文串，那么答案一定为 true ，因为你可以如下分割：
 * aprefix = "", asuffix = "x"
 * bprefix = "", bsuffix = "y"
 * 那么 aprefix + bsuffix = "" + "y" = "y" 是回文串。
 * 示例 2：
 * <p>
 * 输入：a = "abdef", b = "fecab"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：a = "ulacfd", b = "jizalu"
 * 输出：true
 * 解释：在下标为 3 处分割：
 * aprefix = "ula", asuffix = "cfd"
 * bprefix = "jiz", bsuffix = "alu"
 * 那么 aprefix + bsuffix = "ula" + "alu" = "ulaalu" 是回文串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/split-two-strings-to-make-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1616 {
    public static void main(String[] args) {
        Solution1616 solution1616 = new Solution1616();
        // String a = "x", b = "y";
        // String a = "abdef", b = "fecab";

        //   String a = "ulacfd", b = "jizalu";
        String a = "askxrrnhyddrlmcgymtichivmwyjfpyqqxmiimxqqypfjywmvihcitmygcmlryczoygimgii";
        String b = "iigmigyozcyfxgfzkwpvjuxbjphbbmwlhdcavhtjhbpccsxaaiyitfbzljvhjoytfqlqrohv";


        boolean check = solution1616.checkPalindromeFormation(a, b);
        System.out.println(check);
    }

    public boolean checkPalindromeFormation(String a, String b) {
        if (check(a) || check(b)) {
            return true;
        }
        int i = 0;
        int right = a.length() - 1;
        for (; i < a.length(); i++, right--) {
            if (a.charAt(i) != b.charAt(right)) {
                String a1 = a.substring(0, i + 1);
                String a2 = a.substring(i + 1, a.length());
                String b1 = b.substring(0, i + 1);
                String b2 = b.substring(i + 1, a.length());

                String a3 = a.substring(right, a.length());
                String a4 = a.substring(0, right);

                String b3 = b.substring(right, a.length());
                String b4 = b.substring(0, right);
                if (check(a1 + b2) || check(b1 + a2) || check(a3 + b4) || check(b3 + a4)) {
                    return true;
                }
                break;
            }
        }
        i = 0;
        for (; i < a.length(); i++) {
            if (b.charAt(i) != a.charAt(a.length() - 1 - i)) {
                String a1 = a.substring(0, i + 1);
                String a2 = a.substring(i + 1, a.length());
                String b1 = b.substring(0, i + 1);
                String b2 = b.substring(i + 1, a.length());

                String a3 = a.substring(right, a.length());
                String a4 = a.substring(0, right);

                String b3 = b.substring(right, a.length());
                String b4 = b.substring(0, right);
                if (check(a1 + b2) || check(b1 + a2) || check(a3 + b4) || check(b3 + a4)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean check(String a) {
        StringBuffer stringBuffer = new StringBuffer(a);
        String s = stringBuffer.reverse().toString();
        System.out.println(a);
        System.out.println(s);
        System.out.println("===================");
        return s.equals(a);
    }

    public boolean checkPalindromeFormation1(String a, String b) {
        return checkConcatenation(a, b) || checkConcatenation(b, a);
    }

    public boolean checkConcatenation(String a, String b) {
        int n = a.length();
        int left = 0, right = n - 1;
        while (left < right && a.charAt(left) == b.charAt(right)) {
            left++;
            right--;
        }
        if (left >= right) {
            return true;
        }
        return checkSelfPalindrome(a, left, right) || checkSelfPalindrome(b, left, right);
    }

    public boolean checkSelfPalindrome(String a, int left, int right) {
        while (left < right && a.charAt(left) == a.charAt(right)) {
            left++;
            right--;
        }
        return left >= right;
    }

}
