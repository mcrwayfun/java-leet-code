# [Second Minimum Node In a Binary Tree][title]

## Description

Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

**Example 1:**

```
Input: 
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
```

**Example 2:**

```
Input: 
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.
```

**Tags:** Tree 

## 解读题意
给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 

给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。

## 思路1
题目的意思是找出所有节点中第二小的节点（值相同的算一个），那么只要找出比根节点大点的节点即可。若当前节点同时存在左右节点且均比
当前节点大，则进行比较输出较小的值。

```java
class Solution {
    
    public int findSecondMinimumValue(TreeNode root) {
        // root非空
        if (root == null)
            return -1;

        if (root.left == null && root.right == null)
            return -1;

        int left = root.left.val;
        int right = root.right.val;

        // 当前根节点为最小值
        // 父节点与左子树值相等，遍历左子树找到更大的值
        if (root.val == left)
            left = findSecondMinimumValue(root.left);

        // 父节点与右子树值相等，遍历右子树找到更大的值
        if (root.val == right)
            right = findSecondMinimumValue(root.right);
        
        // 左右节点均比根节点大，找出left和right的较小值
        if (left != -1 && right != -1)
            return Math.min(left, right);
        else if (left != -1)
            return left;
        else
            return right;
    }
}
```
time complexity：O（n）


[title]:https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/