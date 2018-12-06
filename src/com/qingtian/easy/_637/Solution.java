package com.qingtian.easy._637;

import com.qingtian.pojo.TreeNode;

import java.util.*;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/07
 * @description
 */
public class Solution {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> doubleList = new ArrayList<>();
        if (root == null)
            return doubleList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            // 当前行的值的和
            double sum = 0.0d;
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            doubleList.add(sum / level);
        }

        return doubleList;
    }

}
