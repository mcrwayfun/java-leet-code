package com.qingtian.easy._897;

import com.qingtian.pojo.TreeNode;
import com.qingtian.util.TreeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/6
 */
public class Solution1 {

    // 当前指针
    private TreeNode last = null;
    private TreeNode newRoot = null;

    public TreeNode increasingBST(TreeNode root) {
        helper(root);
        return newRoot;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        // 中序遍历执行
        helper(root.left);
        if (last == null) {
            last = root;
            newRoot = root;
        } else {
            last.right = root;
            last = root;
            last.left = null;
        }
        helper(root.right);
    }

    public static void main(String[] args) {
        List<Integer> list =
                new ArrayList<>(Arrays.asList(5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9));
        TreeNode treeNode = TreeUtil.genTreeNode(list);
        TreeNode newNode = new Solution1().increasingBST(treeNode);
        TreeUtil.inOrder(newNode);
    }
}
