package com.qingtian.easy._501;

import com.qingtian.pojo.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/11
 */
public class Solution {

    private Map<Integer, Integer> map;

    private int max = 0;

    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[]{};

        map = new HashMap<>();
        midOrder(root);

        // 遍历获取出现次数最多的value
        List<Integer> tempList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max == entry.getValue())
                tempList.add(entry.getKey());
        }

        // 输出到int[]中
        int[] ret = new int[tempList.size()];
        for (int i = 0; i < tempList.size(); i++)
            ret[i] = tempList.get(i);

        return ret;
    }

    private void midOrder(TreeNode root) {
        if (root == null)
            return;

        midOrder(root.left);

        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        max = Math.max(max, map.get(root.val));

        midOrder(root.right);
    }
}
