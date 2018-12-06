# [Maximum Depth of Binary Tree][title]

## Description

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

**Note:** A leaf is a node with no children.

**Example 1:**
Given binary tree `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

**Tags:** Tree

## 解读题意
获取一个二叉树的最大深度

## 思路1 

通过递归方式来寻找最长的分支线，+1是要算上根结点。递归顺序为`3 9 20 15 7`，故time complexity为O(n)

```java
class Solution {
       public int maxDepth(TreeNode root) {

        if (null == root) {
            return 0;
        } else {
            int i = maxDepth(root.left);
            int j = maxDepth(root.right);
            return (i < j) ? j + 1 : i + 1;
        }
    }
}
```
time complexity:O(n)

[title]: https://leetcode.com/problems/maximum-depth-of-binary-tree/description/