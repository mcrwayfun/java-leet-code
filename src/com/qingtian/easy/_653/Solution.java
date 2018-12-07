package com.qingtian.easy._653;

import com.qingtian.pojo.TreeNode;
import com.qingtian.util.TreeUtil;

import java.util.*;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/7
 */
public class Solution {

    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;

        // 将树中的元素输出到orderList中
        List<Integer> orderList = new ArrayList<>();
        midOrder(root, orderList);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < orderList.size(); i++) {
            int sub = k - orderList.get(i);
            if (map.containsKey(sub))
                return true;

            map.put(orderList.get(i), i);
        }

        return false;
    }

    private void midOrder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        midOrder(root.left, list);
        list.add(root.val);
        midOrder(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtil.genTreeNode(new ArrayList<>(Arrays.asList(5, 3, 6, 2, 4, null, 7)));
        new Solution().findTarget(treeNode, 9);

    }
}
