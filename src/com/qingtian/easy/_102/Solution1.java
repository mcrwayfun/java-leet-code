package com.qingtian.easy._102;

import com.qingtian.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/6/6
 */
public class Solution1 {


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> relist = new ArrayList<>();
        if (root == null)
            return relist;

        levelOrderHelper(root, 0, relist);
        return relist;
    }

    private void levelOrderHelper(TreeNode root, int level, List<List<Integer>> relist) {

        if(root == null)
            return;

        if(relist.size() <= level)
            relist.add(new ArrayList<>());


        relist.get(level).add(root.val);
        levelOrderHelper(root.left,level+1,relist);
        levelOrderHelper(root.right,level+1,relist);

    }

    public static void main(String[] args) {
        /**
         *     1
         *    / \
         *   2   2
         *  / \ / \
         * 3  4 4  3
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        List<List<Integer>> lists = new Solution1().levelOrder(root);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
