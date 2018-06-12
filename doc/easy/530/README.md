# [Minimum Absolute Difference in BST][title]

## Description

Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

**Example 1:**

```
Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
```

**Tags:** Tree

## 解读题意
给出一个查找二叉树，找出该树中任意两个结点间相减的最小值的绝对值。

## 思路1 
用中序遍历得到一个有序的数组，那么最小绝对差肯定在相邻的两个结点值之间产生。

```java
class Solution {
    
    private int distance = Integer.MAX_VALUE;

    private Integer pre;


    public int getMinimumDifference(TreeNode root) {

        if (root == null)
            return 0;

        getMinimumDifferenceHelper(root);

        return distance;
    }


    private void getMinimumDifferenceHelper(TreeNode root) {

        if (root == null)
            return;

        getMinimumDifferenceHelper(root.left);
        if (pre != null)
            distance = Math.min(distance, root.val - pre);
        pre = root.val;
        getMinimumDifferenceHelper(root.right);
    }
}
```
time complexity:O(n)


[title]: https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/