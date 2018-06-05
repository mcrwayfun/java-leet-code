package com.qingtian.explore._101;

import com.qingtian.pojo.TreeNode;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/6/5
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        return root == null || (root.left == null && root.right == null) || isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right) {

        if (left == null && right == null)
            return true;

        if (left == null || right == null)
            return false;

        if (left.val != right.val)
            return false;

        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }


    public static void main(String[] args) {

        /**
         *     1
         *    / \
         *   2   2
         *  / \ / \
         * 3  4 4  3
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        boolean symmetric = new Solution().isSymmetric(root);
        System.out.println(symmetric);
    }
}
