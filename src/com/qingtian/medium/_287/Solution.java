package com.qingtian.medium._287;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/17
 */
public class Solution {

    public int findDuplicate(int[] nums) {

        if (nums == null || nums.length == 0)
            return -1;

        int left = 1, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = countRange(nums, left, mid);
            if (left == right) {
                // 存在重复数字
                if (count > 1)
                    return left;

                break;
            } else {
                // 重复数字出现在左闭区间
                if (count > (mid - left) + 1)
                    right = mid;
                else
                    left = mid + 1;
            }
        }

        return -1;
    }

    private int countRange(int[] nums, int start, int right) {

        int count = 0;
        for (int x : nums) {
            if (x >= start && x <= right)
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int duplicate = new Solution().findDuplicate(new int[]{1, 3, 4, 2, 2});
        System.out.println(duplicate);
    }
}
