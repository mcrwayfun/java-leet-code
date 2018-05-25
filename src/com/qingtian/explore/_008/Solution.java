package com.qingtian.explore;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/5/25
 */
public class Solution {

    public int myAtoi(String str) {

        int start = 0;
        int end = str.length();
        char[] chars = str.toCharArray();

        // 首字符为字母
        if ((chars[start] >= 'a' && chars[start] <= 'z') ||
                (chars[start] >= 'A' && chars[start] <= 'Z'))
            return 0;

        int result = 0;
        int sign = 1;
        while (start < end) {

            char num = chars[start];

            // 空字符串
            if (chars[start] == ' ')
                start++;
                // 字母
            else if ((chars[start] >= 'a' && chars[start] <= 'z') ||
                    (chars[start] >= 'A' && chars[start] <= 'Z'))
                start++;
                // 符号
            else if (chars[start] == '+' || chars[start] == '-') {
                sign = chars[start] == '+' ? 1 : -1;
                start++;
            }
            // 数字
            else if (chars[start] >= '0' && chars[start] <= '9') {
                int newResult = result * 10 + (num - '0');
                if ((newResult / 10) != result)
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                result = newResult;
                start++;
            }

        }

        return result * sign;
    }


    public static void main(String[] args) {
        String s = "3.1415926";
        int myAtoi = new Solution().myAtoi(s);
        System.out.println(myAtoi);

    }
}
