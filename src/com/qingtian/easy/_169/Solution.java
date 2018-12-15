package com.qingtian.easy._169;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/15
 * @description
 */
public class Solution {

    public int majorityElement(int[] nums) {

        if (nums == null)
            throw new IllegalArgumentException();

        if (nums.length == 1 || nums.length == 2)
            return nums[0];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            map.put(value, map.getOrDefault(value, 0) + 1);
            if (map.get(value) >= nums.length / 2 + 1)
                return value;
        }

        // 未找到
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        new Solution().majorityElement(nums);
    }
}
