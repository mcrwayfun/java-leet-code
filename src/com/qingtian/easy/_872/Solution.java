package com.qingtian.easy._872;

import com.qingtian.pojo.TreeNode;

import java.util.Stack;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/6
 */
public class Solution {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        else if (root1 == null || root2 == null)
            return false;

        // bfs
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root1);
        stack2.push(root2);

        while (!stack1.empty() && !stack2.empty()) {
            if(leafSimilarHelper(stack1) != leafSimilarHelper(stack2))
                return false;
        }

        return stack1.empty() && stack2.empty();
    }

    public int leafSimilarHelper(Stack<TreeNode> stack) {
        while (true) {
            TreeNode node = stack.pop();
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
            if (node.left == null && node.right == null)
                return node.val;
        }
    }

    public static void main(String[] args) {
        new Solution().leafSimilar(new TreeNode(1),new TreeNode(2));
    }
}
