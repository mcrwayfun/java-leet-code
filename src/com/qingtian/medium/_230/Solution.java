package com.qingtian.medium._230;

import com.qingtian.pojo.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/6/28
 */
public class Solution {

    private int count = 0;
    private int kth = 0;

    public int kthSmallest(TreeNode root, int k) {

        if (root == null || k <= 0)
            return 0;

        // BST中序遍历得到有序列表
        midOrder(root,k);

        return kth;
    }

    private void midOrder(TreeNode root, int k) {

        if (root == null)
            return;

        midOrder(root.left, k);
        count++;
        if (k == count)
            kth = root.val;
        midOrder(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        int kthSmallest = new Solution().kthSmallest(root, 1);
        System.out.println(kthSmallest);
    }
}
