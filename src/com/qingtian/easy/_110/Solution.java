package com.qingtian.easy._110;

import com.qingtian.pojo.TreeNode;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/11
 */
public class Solution {

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        return isBalancedHelper(root) && isBalanced(root.left) && isBalanced(root.right);
    }

    private boolean isBalancedHelper(TreeNode root) {
        if (root == null)
            return true;

        if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1)
            return false;

        return isBalancedHelper(root.left) && isBalancedHelper(root.right);
    }

    private int getDepth(TreeNode root) {
        if (root == null)
            return 0;

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        return Math.max(left, right) + 1;
    }
}
