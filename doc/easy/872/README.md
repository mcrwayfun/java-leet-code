# [Leaf-Similar Trees][title]

## Description

Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.


For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.


**Tags:** Binary Search

## 解读题意
判断两棵树的叶值序列是否相等（对应位置的叶子节点是否相等）

## 思路1 
BFS

```java
class Solution {
    
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

}
```
time complexity:O(lgn)
space complexity:O(n)


[title]: https://leetcode.com/problems/leaf-similar-trees/