# [Convert BST to Greater Tree][title]

## Description

Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

**Example 1:**

```
Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
```

**Tags:** Tree

## 解读题意
给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。

## 思路1 

```java
class Solution {
    
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return null;

        convertBSTHelper(root);
        return root;
    }

    private void convertBSTHelper(TreeNode root) {
        if (root == null) return;
        // 先遍历右子树计算sum
        convertBSTHelper(root.right);
        // 计算根节点sum
        root.val += sum;
        sum = root.val;
        // 遍历左子树计算sum，此时sum已经为遍历根节点和右子树的总和
        convertBSTHelper(root.left);
    }
}
```
time complexity:O(n)


[title]: https://leetcode.com/problems/convert-bst-to-greater-tree/