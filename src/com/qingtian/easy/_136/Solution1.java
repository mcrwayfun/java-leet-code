package com.qingtian.easy._136;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/5/17
 */
public class Solution1 {

    public int singleNumber(int[] nums) {

        int length = nums.length;

        if (length % 2 == 0)
            return 0;

        if (length == 1) {
            return nums[0];
        }

        int numSum = 0;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
            numSum += x;
        }

        int sum = 0;
        for (int x : set) {
            sum += x;
        }

        // sum(set)-sum(nums)得到的就是仅出现一次的数
        return 2 * sum - numSum;

    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] nums = {4, 1, 2, 1, 2};
        // int[] nums = {1, 2, 2};
        int singleNumber = solution.singleNumber(nums);
        System.out.println(singleNumber);
        // int a = 10, b = 5;
        // a = a ^ b;
        // b = a ^ b;
        // a = a ^ b;
        // System.out.println(a);
    }
}
