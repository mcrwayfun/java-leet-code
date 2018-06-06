package com.qingtian.explore._102;

import com.qingtian.pojo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/6/6
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        return levelOrderHelper(root);
    }

    private List<List<Integer>> levelOrderHelper(TreeNode root) {

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        List<List<Integer>> relist = new ArrayList<>();

        if (root == null)
            return relist;

        treeNodeQueue.offer(root);
        while (!treeNodeQueue.isEmpty()) {
            int levelSize = treeNodeQueue.size();
            List<Integer> subList = new LinkedList<>();
            while(levelSize != 0 ){
                if(treeNodeQueue.peek().left != null)treeNodeQueue.offer(treeNodeQueue.peek().left);
                if(treeNodeQueue.peek().right != null)treeNodeQueue.offer(treeNodeQueue.peek().right);
                levelSize--;
                subList.add(treeNodeQueue.poll().val);
            }
            relist.add(subList);
        }

        return relist;
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

        List<List<Integer>> lists = new Solution().levelOrder(root);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
