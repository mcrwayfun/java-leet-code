package com.qingtian.easy._783;

import com.qingtian.pojo.TreeNode;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/6/11
 */
public class Solution1 {

    private int distance = Integer.MAX_VALUE;

    private Integer pre ;

    public int minDiffInBST(TreeNode root) {
        pre = null;

        if (root == null)
            return 0;

        minDiffInBSTHelper(root);

        return distance;
    }

    private void minDiffInBSTHelper(TreeNode root) {

        if (root == null)
            return;

        minDiffInBSTHelper(root.left);
        if(pre != null)
            distance = Math.min(distance, root.val - pre);

        pre = root.val;
        minDiffInBSTHelper(root.right);
    }

    public static void main(String[] args) {
        //  root = [4,2,6,1,3,null,null]
        // /**
        //  *       4
        //  *    2    6
        //  *  1   3
        //  */
        // TreeNode root = new TreeNode(4);
        // root.left = new TreeNode(2);
        // root.left.left = new TreeNode(1);
        // root.left.right = new TreeNode(3);
        // root.right = new TreeNode(6);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(48);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(49);
        int minDiffInBST = new Solution1().minDiffInBST(root);
        System.out.println(minDiffInBST);
    }
}
