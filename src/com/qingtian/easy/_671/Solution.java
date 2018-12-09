package com.qingtian.easy._671;

import com.qingtian.pojo.TreeNode;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/09
 * @description
 */
public class Solution {

    public int findSecondMinimumValue(TreeNode root) {
        // root非空
        if (root == null)
            return -1;

        if (root.left == null && root.right == null)
            return -1;

        int left = root.left.val;
        int right = root.right.val;

        // 当前根节点为最小值
        // 父节点与左子树值相等，遍历左子树找到更大的值
        if (root.val == left)
            left = findSecondMinimumValue(root.left);

        // 父节点与右子树值相等，遍历右子树找到更大的值
        if (root.val == right)
            right = findSecondMinimumValue(root.right);

        if (left != -1 && right != -1)
            return Math.min(left, right);
        else if (left != -1)
            return left;
        else
            return right;
    }

}
