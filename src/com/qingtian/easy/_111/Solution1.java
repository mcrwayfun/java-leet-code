package com.qingtian.easy._111;

import com.qingtian.pojo.TreeNode;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/12
 */
public class Solution1 {

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        int min = Integer.MAX_VALUE;
        if (root.left != null)
            min = Math.min(min, 1 + minDepth(root.left));
        if (root.right != null)
            min = Math.min(min, 1 + minDepth(root.right));

        return min;
    }
}
