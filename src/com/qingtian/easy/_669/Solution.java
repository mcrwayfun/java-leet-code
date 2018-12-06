package com.qingtian.easy._669;

import com.qingtian.pojo.TreeNode;
import com.qingtian.util.TreeUtil;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/06
 * @description
 */
public class Solution {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null)
            return null;

        // 当前节点值小于左区间，则对右区间进行修剪（因为左区间的值必定已经小于L，无修剪必要）
        if (root.val < L) return trimBST(root.right, L, R);
        // 同理
        if (root.val > R) return trimBST(root.left, L, R);

        // 遍历修剪左子树
        root.left = trimBST(root.left, L, R);
        // 遍历修剪右子树
        root.right = trimBST(root.right, L, R);

        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtil.genTreeNode(new int[]{1, 0, 2});
        treeNode = new Solution().trimBST(treeNode, 1, 2);
        TreeUtil.inOrder(treeNode);
    }
}
