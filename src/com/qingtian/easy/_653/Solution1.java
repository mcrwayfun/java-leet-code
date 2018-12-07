package com.qingtian.easy._653;

import com.qingtian.pojo.TreeNode;

import java.util.*;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/7
 */
public class Solution1 {

    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;

        HashSet<Integer> set = new HashSet<>();
        return findTargetHelper(root, k, set);
    }

    private boolean findTargetHelper(TreeNode root, int k, HashSet<Integer> set) {
        if (root == null)
            return false;

        if (set.contains(k - root.val))
            return true;
        else
            set.add(root.val);

        return findTargetHelper(root.left, k, set) || findTargetHelper(root.right, k, set);
    }
}
