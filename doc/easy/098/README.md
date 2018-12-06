# [Validate Binary Search Tree][title]

## Description
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:
- The left subtree of a node contains only nodes with keys less than the node's key.
- The right subtree of a node contains only nodes with keys greater than the node's key.
- Both the left and right subtrees must also be binary search trees.


**Example 1:**
```
  Input:
    2
   / \
  1   3
Output: true
```
**Example 2:**
```
    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.
```

**Tags:** Tree

## 解读题意
BST（二叉查找树）：左子树的值小于结点值；右子树的值大于结点值；左子树和右子树必须也是二叉树；
该题是判断一棵树是不是二叉查找树。

## 思路1 
1. 根结点root为null，为空树，符合BST定义
2. 仅存在根结点root，符合BST定义
3. 申明方法：`isValidBST(TreeNode root, long min, long max)`。递归比较左子树，最小值比`min`大，最大值比`max`小（max动态改变，为当前结点的父节点`val - 1`）；递归比较右子树，最大值比`max`小，最小值比`min`大（min动态改变，为当前结点的父节点`val + 1`）

```java
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;

        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {

        if (root == null)
            return true;

        if (root.val < min || root.val > max)
            return false;

        return isValidBST(root.left, min, (long)root.val - 1) &&
                isValidBST(root.right, (long)root.val + 1, max);
    }
}
```
time complexity:O(n)

[title]: https://leetcode.com/problems/validate-binary-search-tree/description/