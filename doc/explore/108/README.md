# [Convert Sorted Array to Binary Search Tree][title]

## Description
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

**Example 1:**
Given the sorted array: `[-10,-3,0,5,9]`,

One possible answer is: `[0,-3,9,-10,null,5]`, which represents the following height balanced BST:

```
      0
     / \
   -3   9
   /   /
 -10  5
```

**Tags:** Tree

## 解读题意
给定一个有序的数组，将其组成一个查找二叉树，即BST。BST需要满足：左结点 < 中结点 < 右结点特性。

## 思路1 

如果将查找二叉树进行中序遍历，得到的便是一个有序数组。那么反过来，根结点便是有序数组的中点。接下来用二分法的思想来解决创建出查找二叉树。
1. 找到有序数组的中点`int mid = (nums.length - 1)/2`,将数组分为左右两个数组
2. 以当前中点的值`nums[mid]`创建根结点
3. 再分别以左右两个有序数组为原型，递归执行步骤1，2

```java
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }


    private TreeNode sortedArrayToBSTHelper(int[] nums, int left, int right) {
        if (left > right)
            return null;

        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTHelper(nums, left, mid - 1);
        root.right = sortedArrayToBSTHelper(nums, mid + 1, right);

        return root;
    }

}
```
time complexity:O(n)

[title]: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/