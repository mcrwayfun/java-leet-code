package com.qingtian.easy._783;

import com.qingtian.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/6/11
 */
public class Solution {


    public int minDiffInBST(TreeNode root) {

        List<Integer> tempList = new ArrayList<>();

        int distance = Integer.MAX_VALUE;
        minDiffInBSTHelper(root,tempList);

        for (int i = 1; i < tempList.size(); i++) {
            distance = Math.min(distance,tempList.get(i)-tempList.get(i-1));
        }

        return distance;
    }

    private void minDiffInBSTHelper(TreeNode root, List<Integer> vals) {

        if (root == null)
            return;

        minDiffInBSTHelper(root.left, vals);
        vals.add(root.val);
        minDiffInBSTHelper(root.right, vals);

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
        int minDiffInBST = new Solution().minDiffInBST(root);
        System.out.println(minDiffInBST);
    }
}
