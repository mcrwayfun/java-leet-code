package com.qingtian.easy._169;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/15
 * @description
 */
public class Solution1 {

    public int majorityElement(int[] nums) {

        if (nums == null)
            throw new IllegalArgumentException();

        if (nums.length == 1 || nums.length == 2)
            return nums[0];

        // 遇到相同的值则count++,否则count--
        // 当count为0时重新获取major,并且count重新计算值
        int major = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (major == nums[i]) {
                count++;
            } else {
                if (count == 0) {
                    major = nums[i];
                    count = 1;
                } else {
                    count--;
                }
            }
        }

        return major;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 1, 1, 2, 2, 2};
        new Solution1().majorityElement(nums);
    }
}
