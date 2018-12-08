package com.qingtian.easy._107;

import com.qingtian.pojo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/09
 * @description
 */
public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> retList = new LinkedList<>();
        if (root == null)
            return retList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();

                if (node != null && node.left != null)
                    queue.add(node.left);

                if (node != null && node.right != null)
                    queue.add(node.right);

                list.add(node.val);
            }
            retList.add(0, list);
        }

        return retList;
    }
}
