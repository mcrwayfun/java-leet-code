# [Merge Two Binary Trees][title]

## Description

Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

**Example 1:**

```
Input: 
    1
   / \
  0   2

  L = 1
  R = 2

Output: 
    1
      \
       2
```

**Tags:** Tree 

## 解读题意
对一棵BST树进行修剪，修剪范围为[L,R]，修剪后的树依然符合BST

## 思路1

1. 若当前节点值小于左区间，则对右区间进行修剪（因为左子树的值必定已经小于L，无修剪必要）
2. 若当前节点值大于右区间，则对左区间进行修剪（因为右子树的值必定已经大于R，无修剪必要）
3. 递归修剪左子树
4. 递归修剪右子树


```java
class Solution {
    
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null)
            return null;

        // 当前节点值小于左区间，则对右区间进行修剪（因为左区间的值必定已经小于L，无修剪必要）
        if (root.val < L) return trimBST(root.right, L, R);
        // 同理
        if (root.val > R) return trimBST(root.left, L, R);

        // 遍历修剪左子树
        root.left = trimBST(root.left, L, R);
        // 遍历修剪右子树
        root.right = trimBST(root.right, L, R);

        return root;
    }
}
```
time complexity：O（n）


[title]:https://leetcode.com/problems/trim-a-binary-search-tree/