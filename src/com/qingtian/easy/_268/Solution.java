package com.qingtian.easy._268;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/15
 * @description
 */
public class Solution {

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new IllegalArgumentException();

        // 使用异或操作，a^b^b=a
        // 这意味着两个数值相同的异或可消除并显示原来的数字
        int xor = 0, i = 0;
        for (; i < nums.length; i++)
            // 使用下标和对应的值进行异或
            xor = xor ^ i ^ nums[i];

        // 与n进行异或
        return xor ^ i;
    }

    public static void main(String[] args) {
        int missingNumber = new Solution().missingNumber(new int[]{3, 0, 1});
        System.out.println("missingNumber=" + missingNumber);
    }
}
