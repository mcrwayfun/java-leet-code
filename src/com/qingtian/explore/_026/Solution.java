package com.qingtian.explore._026;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/05/13
 */
public class Solution {

    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        // 有序列表！
        int[] nums = new int[]{1, 1, 1,3, 5,5};
        Solution solution = new Solution();
        int size = solution.removeDuplicates(nums);
        System.out.println(size);
    }

}
