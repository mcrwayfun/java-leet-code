# [Longest Univalue Path][title]

## Description

Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

Note: The length of path between two nodes is represented by the number of edges between them.

**Example 1:**

```
Input:

              5
             / \
            4   5
           / \   \
          1   1   5
Output:

2
```

**Example 2**
```
Input:

              1
             / \
            4   5
           / \   \
          4   4   5
Output:

2
```

**Tags:** Stack

## 思路1 

```java
class Solution {
    
    int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;

        longestUnivaluePathHelper(root);

        return res;
    }

    private int longestUnivaluePathHelper(TreeNode root) {
        int left = root.left != null ? longestUnivaluePathHelper(root.left) : 0;
        int right = root.right != null ? longestUnivaluePathHelper(root.right) : 0;

        int resL = root.left != null && root.left.val == root.val ? left + 1 : 0;
        int resR = root.right != null && root.right.val == root.val ? right + 1 : 0;
        res = Math.max(res, resL + resR);

        // resL或者resR可能存在0，返回其
        return Math.max(resL, resR);
    }
}
```
time complexity:O(n)


[title]: https://leetcode.com/problems/longest-univalue-path/