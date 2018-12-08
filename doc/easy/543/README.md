# [Diameter of Binary Tree][title]

## Description

Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

**Example 1:**

```
          1
         / \
        2   3
       / \     
      4   5  
        
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
```

**Tags:** Tree

## 解读题意
给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。

## 思路1 

```java
class Solution {
    
    private int max;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        diameterOfBinaryTreeHelper(root);
        return max;
    }

    private int diameterOfBinaryTreeHelper(TreeNode root) {
        if (root == null)
            return 0;

        int left = diameterOfBinaryTreeHelper(root.left);
        int right = diameterOfBinaryTreeHelper(root.right);

        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
```
time complexity:O(n)


[title]: https://leetcode.com/problems/diameter-of-binary-tree/