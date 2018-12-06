# [Search in a Binary Search Tree][title]

## Description

Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.

**Example 1:**

```java
Given the tree:
        4
       / \
      2   7
     / \
    1   3

And the value to search: 2

You should return this subtree:

      2     
     / \   
    1   3
```



Tags:** Binary Tree

## 解读题意


## 思路1 

```java
class Solution {
   
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;

        // 判断根节点
        if (root.val == val)
            return root;

        // 遍历左子树
        TreeNode left = searchBST(root.left, val);
        // 遍历右子树
        TreeNode right = searchBST(root.right, val);

        if(left != null && right == null)
            return left;
        if(left == null && right != null)
            return right;

        // 都找不到
        return null;
    }
}
```

time complexity：O(lgn)


[title]: https://leetcode.com/problems/search-in-a-binary-search-tree/
