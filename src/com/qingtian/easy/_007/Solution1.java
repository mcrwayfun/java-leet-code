package com.qingtian.easy._007;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/5/23
 */
public class Solution1 {

    public int reverse(int x) {

        int result = 0;

        while (x != 0) {

            int newResult = result * 10 + x % 10;
            // 溢出有损失，所以不等于原来的数
            if ((newResult) / 10 != result)
                return 0;

            result = newResult;
            x = x / 10;
        }

        return result;
    }


    public static void main(String[] args) {
        int x = -123;
        int reverse = new Solution1().reverse(1534236469);
        System.out.println(reverse);
    }
}
