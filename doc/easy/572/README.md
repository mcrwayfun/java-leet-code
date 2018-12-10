# [Subtree of Another Tree][title]

## Description

Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

**Example 1:**
```
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
```

**Example 2:**
```
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.
```
**Tags:** Tree

## 解读题意
判断t是否为s的子树

## 思路1 
涉及多个节点，注意在根节点处的递归

```java
class Solution {
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;

        return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;

        if (s == null || t == null)
            return false;

        if (s.val != t.val)
            return false;

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
```
time complexity:O(n)


[title]: https://leetcode.com/problems/subtree-of-another-tree/