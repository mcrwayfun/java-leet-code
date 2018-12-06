package com.qingtian.easy._590;

import com.qingtian.pojo.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/6
 */
public class Solution {

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        postorderHelper(root, list);
        return list;
    }

    private void postorderHelper(Node root, List<Integer> list) {
        if (root == null)
            return;

        for (Node node : root.children)
            postorderHelper(node, list);

        list.add(root.val);
    }

}
