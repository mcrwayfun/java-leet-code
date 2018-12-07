package com.qingtian.easy._429;

import com.qingtian.pojo.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/7
 */
public class Solution {

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> reList = new ArrayList<>();
        if (root == null)
            return reList;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 当前层存在多少个元素
            int level = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                Node add = queue.poll();
                if (add != null) {
                    list.add(add.val);
                    queue.addAll(add.children);
                }
            }

            reList.add(list);
        }

        return reList;
    }
}
