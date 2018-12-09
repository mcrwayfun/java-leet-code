package com.qingtian.easy._257;

import com.qingtian.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/09
 * @description
 */
public class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> retList = new ArrayList<>();
        if (root == null)
            return retList;

        binaryTreePathsHelper(root, retList, "");
        return retList;
    }

    private void binaryTreePathsHelper(TreeNode root, List<String> list, String res) {
        if (root.left == null && root.right == null) {
            list.add(res + root.val);
            return;
        }

        res = res + root.val + "->";

        if (root.left != null)
            binaryTreePathsHelper(root.left, list, res);
        if (root.right != null)
            binaryTreePathsHelper(root.right, list, res);
    }
}
