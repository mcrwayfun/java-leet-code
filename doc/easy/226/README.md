# [Invert Binary Tree][title]

## Description

Invert a binary tree.

**Example 1:**

```
  	 4
   /   \
  2     7
 / \   / \
1   3 6   9

     4
   /   \
  7     2
 / \   / \
9   6 3   1
```

**Tags:** Binary Tree


## 解读题意
翻转一棵二叉树。

## 思路1 

```java
class Solution { 
  
    public TreeNode invertTree(TreeNode root) {

        if (root == null)
            return null;


        final TreeNode left = root.left,
                right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

}
```
分析：

[title]:https://leetcode.com/problems/invert-binary-tree/