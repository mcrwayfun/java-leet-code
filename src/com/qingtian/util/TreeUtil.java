package com.qingtian.util;

import com.qingtian.pojo.TreeNode;

import java.util.List;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/6
 */
public class TreeUtil {

    private static TreeNode root;

    public static TreeNode genTreeNode(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        for (int x : arr)
            add(x);

        return root;
    }

    public static TreeNode genTreeNode(List<Integer> list) {
        if (list == null || list.isEmpty())
            return null;

        for (Integer x : list)
            add(x);

        return root;
    }

    // 向二分搜索树中添加新的元素e
    public static void add(Integer e) {
        root = add(root, e);
    }

    // 向以node为根的二分搜索树中插入元素e，递归算法
    // 返回插入新结点后二分搜索树的根
    private static TreeNode add(TreeNode node, Integer e) {

        if (node == null) {
            return new TreeNode(e);
        }

        if (e != null && e < node.val)
            node.left = add(node.left, e);
            // e > node.e
        else if (e != null && e > node.val)
            node.right = add(node.right, e);

        return node;
    }


    // 中序遍历以node为根的二分搜索树, 递归算法
    public static void inOrder(TreeNode node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }
}
