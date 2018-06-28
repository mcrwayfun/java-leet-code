# [Kth Smallest Element in a BST][title]

## Description

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

**Note:**You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

**Example 1:**

```
Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
```

**Example 2:**

```
Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
```

**Tags:** Binary Search

## 解读题意
找出二叉搜索树中第k个大的元素

## 思路1 
这是一道典型的二叉搜索树遍历问题。对二叉搜索树进行中序遍历可以得到有序的数组，访问其对应元素即可。

```java
public class Solution {

    private int count = 0;
    private int kth = 0;

    public int kthSmallest(TreeNode root, int k) {

        if (root == null || k <= 0)
            return 0;

        // BST中序遍历得到有序列表
        midOrder(root,k);

        return kth;
    }

    private void midOrder(TreeNode root, int k) {

        if (root == null)
            return;

        midOrder(root.left, k);
        count++;
        if (k == count)
            kth = root.val;
        midOrder(root.right, k);
    }
}
```
time complexity:O(n)。


[title]: https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/