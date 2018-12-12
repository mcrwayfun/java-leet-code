# [Minimum Depth of Binary Tree][title]

## Description
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

**Example 1:**
```
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.
```

**Tags:** Tree

## 解读题意
找出二叉树中的最短路径！（路径定义为：根节点到叶子节点）

## 思路1 

```java
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        int min = Integer.MAX_VALUE;
        if (root.left != null)
            min = Math.min(min, 1 + minDepth(root.left));
        if (root.right != null)
            min = Math.min(min, 1 + minDepth(root.right));

        return min;
    }
}
```
time complexity:O(n)

[title]: https://leetcode.com/problems/minimum-depth-of-binary-tree/