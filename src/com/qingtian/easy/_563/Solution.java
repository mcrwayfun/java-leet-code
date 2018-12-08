package com.qingtian.easy._563;

import com.qingtian.pojo.TreeNode;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/08
 * @description
 */
public class Solution {

    private int result;

    public int findTilt(TreeNode root) {
        if (root == null)
            return 0;

        postOrder(root);
        return result;
    }

    private int postOrder(TreeNode root) {
        if (root == null)
            return 0;

        int left = postOrder(root.left);
        int right = postOrder(root.right);

        result += Math.abs(left - right);

        return left + root.val + right;
    }
}
