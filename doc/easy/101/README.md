# [Symmetric Tree][title]

## Description
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

**Example 1:**
For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
```
  Input:
    1
   / \
  2   2
 / \ / \
3  4 4  3
Output: true
```
**Example 2:**
But the following [1,2,2,null,3,null,3] is not:
```
    1
   / \
  2   2
   \   \
   3    3
Output: false
```

**Tags:** Tree

## 解读题意
判断一棵二叉树是不是对称的

## 思路1 
1. 根结点为空是空树，空树是对称树，返回true
2. 根结点存在且无左右子树，是对称树，返回true
3. 申明方法`isSymmetricHelp(TreeNode left, TreeNode right)`进行递归判断，假设有两个结点n1，n2。需要判断n1的左子结点和n2的右子结点值是否相等，n1的右子结点和n2的左子结点值是否相等。

```java
class Solution {
   public boolean isSymmetric(TreeNode root) {
        return root == null || (root.left == null && root.right == null) || isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right) {

        if (left == null && right == null)
            return true;

        if (left == null || right == null)
            return false;

        if (left.val != right.val)
            return false;

        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }
}
```
time complexity:O(n)

[title]: https://leetcode.com/problems/symmetric-tree/description/