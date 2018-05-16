package com.qingtian.explore._217;

import java.util.Arrays;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/5/16
 */
public class Solution {

    public boolean containsDuplicate(int[] nums) {
        // 排序
        Arrays.sort(nums);
        // 比较，值相同必定相邻
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i+1])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,5,6,8,3,12,24,2};
        boolean result = solution.containsDuplicate(nums);
        System.out.println(result);
    }
}
