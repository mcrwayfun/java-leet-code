package com.qingtian.easy._098;

import com.qingtian.pojo.TreeNode;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/06/04
 */
public class Solution {


    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;

        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {

        if (root == null)
            return true;

        if (root.val < min || root.val > max)
            return false;

        return isValidBST(root.left, min, (long)root.val - 1) &&
                isValidBST(root.right, (long)root.val + 1, max);
    }


    public static void main(String[] args) {
        /**
         *       4
         *    2     5
         *  1   3
         */
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        boolean validBST = new Solution().isValidBST(root);
        System.out.println(validBST);
    }
}
