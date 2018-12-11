# [Balanced Binary Tree][title]

## Description
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

**Example 1:**
```
Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.
```

**Example 2:**
```
Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
```

**Tags:** Tree

## 解读题意
判断是否为绝对平衡树：左右节点深度不超过1

## 思路1 

```java
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        return isBalancedHelper(root) && isBalanced(root.left) && isBalanced(root.right);
    }

    private boolean isBalancedHelper(TreeNode root) {
        if (root == null)
            return true;

        if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1)
            return false;

        return isBalancedHelper(root.left) && isBalancedHelper(root.right);
    }

    private int getDepth(TreeNode root) {
        if (root == null)
            return 0;

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        return Math.max(left, right) + 1;
    }
}
```
time complexity:O(n)

[title]: https://leetcode.com/problems/balanced-binary-tree/