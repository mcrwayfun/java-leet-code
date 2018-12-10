package com.qingtian.easy._572;

import com.qingtian.pojo.TreeNode;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/10
 * @description
 */
public class Solution {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;

        return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;

        if (s == null || t == null)
            return false;

        if (s.val != t.val)
            return false;

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
