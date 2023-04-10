package com.trip.algorithm.leet.some.leet2304;

/**
 * @author xbguo
 * @date 2023/4/6 17:06
 * 电话号码：
 * <p>
 * 一个电话号码应当按下述格式组成：
 * <p>
 * 电话号码可以由 10-13 位数字组成
 * 后 10 位构成 本地号码
 * 前面剩下的 0-3 位，构成 国家代码
 * 利用 {'+', '-', '(', ')', ' '} 这些 分隔字符 按某种形式对上述数字进行分隔
 * 要想隐藏电话号码中的个人信息：
 * <p>
 * 移除所有 分隔字符
 * 隐藏个人信息后的电话号码应该遵从这种格式：
 * "***-***-XXXX" 如果国家代码为 0 位数字
 * "+*-***-***-XXXX" 如果国家代码为 1 位数字
 * "+**-***-***-XXXX" 如果国家代码为 2 位数字
 * "+***-***-***-XXXX" 如果国家代码为 3 位数字
 * "XXXX" 是最后 4 位 本地号码
 *  
 * <p>
 * 输入：s = "LeetCode@LeetCode.com"
 * 输出："l*****e@leetcode.com"
 * 解释：s 是一个电子邮件地址。
 * 名字和域名都转换为小写，名字的中间用 5 个 * 替换。
 * 示例 2：
 * <p>
 * 输入：s = "AB@qq.com"
 * 输出："a*****b@qq.com"
 * 解释：s 是一个电子邮件地址。
 * 名字和域名都转换为小写，名字的中间用 5 个 * 替换。
 * 注意，尽管 "ab" 只有两个字符，但中间仍然必须有 5 个 * 。
 * 示例 3：
 * <p>
 * 输入：s = "1(234)567-890"
 * 输出："***-***-7890"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/masking-personal-information
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution831 {
    public static void main(String[] args) {
        String s1 = "LeetCode@LeetCode.com";
        s1 = "AB@qq.com";
        s1 = "1(234)567-890";
        String s = maskPII(s1);
        System.out.println(s);
    }

    public static String maskPII(String s) {

        StringBuffer stringBuffer = new StringBuffer();
        if (s.indexOf("@") != -1) {
            String s1 = s.toLowerCase();
            int index = s1.indexOf("@");
            stringBuffer.append(s1.charAt(0)).append("*****");
            stringBuffer.append(s1.charAt(index - 1));
            stringBuffer.append(s1.substring(index));
            return stringBuffer.toString();
        } else {
            //'+', '-', '(', ')', ' '
            s = s.replace("+", "");
            s = s.replace("-", "");
            s = s.replace("(", "");
            s = s.replace(")", "");
            s = s.replace(" ", "");
            /**
             *  * "***-***-XXXX" 如果国家代码为 0 位数字
             *  * "+*-***-***-XXXX" 如果国家代码为 1 位数字
             *  * "+**-***-***-XXXX" 如果国家代码为 2 位数字
             *  * "+***-***-***-XXXX" 如果国家代码为 3 位数字
             */
            String substring = s.substring(s.length() - 4);
            if (s.length() == 10) {
                return "***-***-" + substring;
            } else if (s.length() == 11) {
                return "+*-***-***-" + substring;
            } else if (s.length() == 12) {
                return "+**-***-***-" + substring;
            } else if (s.length() == 13) {
                return "+***-***-***-" + substring;
            }
        }
        return "";
    }
}
