package com.qingtian.explore._108;

import com.qingtian.pojo.TreeNode;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/6/7
 */
public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }


    private TreeNode sortedArrayToBSTHelper(int[] nums, int left, int right) {
        if (left > right)
            return null;

        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTHelper(nums, left, mid - 1);
        root.right = sortedArrayToBSTHelper(nums, mid + 1, right);

        return root;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        new Solution().sortedArrayToBST(nums);
    }

}
