package com.qingtian.easy._559;

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

    public int maxDepth(Node root) {
        if (root == null)
            return 0;

        int maxDepth = 0;
        for (Node node : root.children)
            if (node.children != null)
                maxDepth = Math.max(maxDepth, maxDepth(node));

        return maxDepth + 1;
    }

}
