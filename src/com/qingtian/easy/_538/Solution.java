package com.qingtian.easy._538;

import com.qingtian.pojo.TreeNode;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/7
 */
public class Solution {

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return null;

        convertBSTHelper(root);
        return root;
    }

    private void convertBSTHelper(TreeNode root) {
        if (root == null) return;
        // 先遍历右子树计算sum
        convertBSTHelper(root.right);
        // 计算根节点sum
        root.val += sum;
        sum = root.val;
        // 遍历左子树计算sum，此时sum已经为遍历根节点和右子树的总和
        convertBSTHelper(root.left);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(13);
        new Solution().convertBST(treeNode);
    }
}
