package com.qingtian.easy._007;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/5/23
 */
public class Solution {


    public int reverse(int x) {

        long result = 0;

        while(x != 0){
            result = result * 10 + x % 10;
            if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
            x /= 10;
        }

        return (int)result;
    }


    public static void main(String[] args) {
        int x = -123;
        int reverse = new Solution().reverse(x);
        System.out.println(reverse);
    }

}
