package com.qingtian.easy._687;

import com.qingtian.pojo.TreeNode;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/12
 */
public class Solution {

    int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;

        longestUnivaluePathHelper(root);

        return res;
    }

    private int longestUnivaluePathHelper(TreeNode root) {
        int left = root.left != null ? longestUnivaluePathHelper(root.left) : 0;
        int right = root.right != null ? longestUnivaluePathHelper(root.right) : 0;

        int resL = root.left != null && root.left.val == root.val ? left + 1 : 0;
        int resR = root.right != null && root.right.val == root.val ? right + 1 : 0;
        res = Math.max(res, resL + resR);

        // resL或者resR可能存在0，返回其
        return Math.max(resL, resR);
    }

    public static void main(String[] args) {
        /**
         *               1
         *              / \
         *             4   5
         *            / \   \
         *           4   4   5
         */
        TreeNode root4 = new TreeNode(4);
        root4.left = new TreeNode(4);
        root4.right = new TreeNode(4);

        TreeNode root5 = new TreeNode(5);
        root5.right = new TreeNode(5);

        TreeNode root1 = new TreeNode(1);
        root1.left = root4;
        root1.right = root5;

        int longestUnivaluePath = new Solution().longestUnivaluePath(root1);
        System.out.println("longestUnivaluePath:" + longestUnivaluePath);
    }
}
