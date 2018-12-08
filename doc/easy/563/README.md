# [Maximum Depth of N-ary Tree][title]

## Description

Given a binary tree, return the tilt of the whole tree.

The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

**Example 1:**

Input: 
​         1
​       /   \
​      2     3
Output: 1
Explanation: 
Tilt of node 2 : 0
Tilt of node 3 : 0
Tilt of node 1 : |2-3| = 1
Tilt of binary tree : 0 + 0 + 1 = 1

**Tags:** Tree

## 解读题意
给定一个二叉树，计算整个树的坡度。

一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。整个树的坡度就是其所有节点的坡度之和。

## 思路1 

1. 使用后序遍历，因为其操作过程为左右根（右左根也可以）
2. postOrder返回值为left+root.val+right(要算上当前节点的值)

```java
class Solution {
    
    private int result;

    public int findTilt(TreeNode root) {
        if (root == null)
            return 0;

        postOrder(root);
        return result;
    }

    private int postOrder(TreeNode root) {
        if (root == null)
            return 0;

        int left = postOrder(root.left);
        int right = postOrder(root.right);

        result += Math.abs(left - right);

        return left + root.val + right;
    }
}
```
time complexity:O(n)


[title]: https://leetcode.com/problems/binary-tree-tilt/