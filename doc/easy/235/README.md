# [Lowest Common Ancestor of a Binary Search Tree][title]

## Description
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”


**Example1:**
```

Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
         
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.   
```

**Example2:**
```
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself 
             according to the LCA definition.
```

**Tags:** Tree

## 解读题意
给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

## 思路1 
这是一棵BST，所以有左<根<右的性质，所以：
- root.val > Math.max(p.val,q.val)，则p和q均在左子树中
- root.val < Math.min(p.val,q.val)，则p和q均在右子树中

```java
class Solution { 
  
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        // root.val > Math.max(p.val,q.val)，则p和q均在左子树中
        if (root.val > Math.max(p.val, q.val))
            root = lowestCommonAncestor(root.left, p, q);
            // root.val < Math.min(p.val,q.val)，则p和q均在右子树中
        else if (root.val < Math.min(p.val, q.val))
            root = lowestCommonAncestor(root.right, p, q);

        return root;
    }

}
```

[title]: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/