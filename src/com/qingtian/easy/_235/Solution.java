package com.qingtian.easy._235;

import com.qingtian.pojo.TreeNode;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/10
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        // root.val > Math.max(p.val,q.val)，则p和q均在左子树中
        if (root.val > Math.max(p.val, q.val))
            root = lowestCommonAncestor(root.left, p, q);
            // root.val < Math.min(p.val,q.val)，则p和q均在右子树中
        else if (root.val < Math.min(p.val, q.val))
            root = lowestCommonAncestor(root.right, p, q);

        return root;
    }
}
