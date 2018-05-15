package com.qingtian.explore._189;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/05/15
 */
public class Solution {

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        // 数组顺序全部反过来
        reverse(nums, 0, nums.length - 1);
        // 反转前k个
        reverse(nums, 0, k - 1);
        // 反转n-k个
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {

        int temp = 0;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        solution.rotate(nums,k);
    }

}
