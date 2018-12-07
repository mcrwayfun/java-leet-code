package com.qingtian.easy._404;

import com.qingtian.pojo.TreeNode;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/7
 */
public class Solution {


    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;

        int sum = 0;
        if (root.left != null) {
            // 当前节点的左子树是叶子节点
            if (root.left.left == null && root.left.right == null)
                sum += root.left.val;
            else
                // 还不是叶子节点，则继续遍历左子树
                sum += sumOfLeftLeaves(root.left);
        }

        // 遍历右子树
        sum += sumOfLeftLeaves(root.right);

        return sum;
    }


}
