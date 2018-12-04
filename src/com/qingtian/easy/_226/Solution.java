package com.qingtian.easy._226;

import com.qingtian.pojo.TreeNode;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/4
 */
public class Solution {

    public TreeNode invertTree(TreeNode root) {

        if (root == null)
            return null;


        final TreeNode left = root.left,
                right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}
