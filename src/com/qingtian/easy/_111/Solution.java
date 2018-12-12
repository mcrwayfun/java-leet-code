package com.qingtian.easy._111;

import com.qingtian.pojo.TreeNode;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/12
 */
public class Solution {

    int min = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        // only root
        if (root.left == null && root.right == null)
            return 1;

        int depth = 1;
        if (root.left != null)
            minDepthHelper(root.left, depth);
        if (root.right != null)
            minDepthHelper(root.right, depth);

        return min;
    }

    private void minDepthHelper(TreeNode root, int depth) {
        depth += 1;

        if (root.left == null && root.right == null) {
            min = Math.min(min, depth);
        }


        if (root.left != null)
            minDepthHelper(root.left, depth);
        if (root.right != null)
            minDepthHelper(root.right, depth);
    }

    public static void main(String[] args) {
        /**
         *     3
         *    / \
         *   9  20
         *     /  \
         *    15   7
         */
        TreeNode root15 = new TreeNode(15);
        TreeNode root7 = new TreeNode(7);

        TreeNode root20 = new TreeNode(20);
        root20.left = root15;
        root20.right = root7;

        TreeNode root9 = new TreeNode(9);

        TreeNode root3 = new TreeNode(3);
        root3.left = root9;
        root3.right = root20;

        int minDepth = new Solution().minDepth(root3);
        System.out.println("minDepth:" + minDepth);
    }
}
