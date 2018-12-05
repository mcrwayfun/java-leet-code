package com.qingtian.easy._589;

import com.qingtian.pojo.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/5
 */
public class Solution {

    public List<Integer> preorder(Node root) {
        List<Integer> reList = new ArrayList<>();

        if (root == null)
            return reList;

        preorderHelper(root, reList);
        return reList;
    }

    private void preorderHelper(Node root, List<Integer> list) {
        if (root == null)
            return;

        list.add(root.val);
        for (Node node : root.children)
            preorderHelper(node, list);
    }
}
