package com.qingtian.easy._530;

import com.qingtian.pojo.TreeNode;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/6/12
 */
public class Solution {

    private int distance = Integer.MAX_VALUE;

    private Integer pre;


    public int getMinimumDifference(TreeNode root) {

        if (root == null)
            return 0;

        getMinimumDifferenceHelper(root);

        return distance;
    }


    private void getMinimumDifferenceHelper(TreeNode root) {

        if (root == null)
            return;

        getMinimumDifferenceHelper(root.left);
        if (pre != null)
            distance = Math.min(distance, root.val - pre);
        pre = root.val;
        getMinimumDifferenceHelper(root.right);
    }

    public static void main(String[] args) {
        //  root = [4,2,6,1,3,null,null]
        /**
         *       4
         *    2    6
         *  1   3
         */
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        int minimumDifference = new Solution().getMinimumDifference(root);
        System.out.println(minimumDifference);
    }

}
