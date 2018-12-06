package com.qingtian.easy._897;

import com.qingtian.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/6
 */
public class Solution {

    public TreeNode increasingBST(TreeNode root) {
        if (root == null)
            return null;

        return increasingBSTHelper(root, null);
    }

    private TreeNode increasingBSTHelper(TreeNode root, TreeNode tail) {
        if (root == null)
            return tail;
        // 左子树置空，右子树转移到tail上
        // 先处理左子树
        TreeNode resNode = increasingBSTHelper(root.left, root);
        root.left = null;
        // 处理右子树
        root.right = increasingBSTHelper(root.right, tail);

        return resNode;
    }

}
