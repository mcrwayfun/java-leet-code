package com.qingtian.easy._112;

import com.qingtian.pojo.TreeNode;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/12
 */
public class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null)
            return root.val == sum;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        new Solution().hasPathSum(treeNode, 2);
    }
}
