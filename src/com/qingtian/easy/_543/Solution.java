package com.qingtian.easy._543;

import com.qingtian.pojo.TreeNode;
import com.qingtian.util.TreeUtil;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/08
 * @description
 */
public class Solution {

    private int max;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        diameterOfBinaryTreeHelper(root);
        return max;
    }

    private int diameterOfBinaryTreeHelper(TreeNode root) {
        if (root == null)
            return 0;

        int left = diameterOfBinaryTreeHelper(root.left);
        int right = diameterOfBinaryTreeHelper(root.right);

        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtil.genTreeNode(new int[]{1, 2, 3});
        new Solution().diameterOfBinaryTree(treeNode);
    }
}
