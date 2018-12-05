package com.qingtian.explore._104;

import com.qingtian.pojo.TreeNode;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/06/03
 */
public class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        int maxDepth = new Solution().maxDepth(node1);
        System.out.println(maxDepth);
    }
}
