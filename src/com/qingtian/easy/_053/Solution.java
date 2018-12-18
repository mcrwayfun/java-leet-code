package com.qingtian.easy._053;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/18
 */
public class Solution {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        if (nums == null || nums.length == 0)
            return max;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果加上前一个数sum变为负数，则sum重新取当前值计算
            if (sum < 0)
                sum = nums[i];
            else
                sum += nums[i];

            if (sum > max)
                max = sum;
        }

        return max;
    }

    public static void main(String[] args) {
        int maxSubArray = new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(maxSubArray);
    }
}
