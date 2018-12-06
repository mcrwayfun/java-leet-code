package com.qingtian.easy._700;

import com.qingtian.pojo.TreeNode;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/6
 */
public class Solution {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;

        // 判断根节点
        if (root.val == val)
            return root;

        // 遍历左子树
        TreeNode left = searchBST(root.left, val);
        // 遍历右子树
        TreeNode right = searchBST(root.right, val);

        if(left != null && right == null)
            return left;
        if(left == null && right != null)
            return right;

        // 都找不到
        return null;
    }

}
