# [Sum of Left Leaves][title]

## Description

Find the sum of all left leaves in a given binary tree.

**Example 1:**

```
    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
```

**Tags:** Tree

## 解读题意
要找到树中所有的左叶子节点

```java
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;

        int sum = 0;
        if (root.left != null) {
            // 当前节点的左子树是叶子节点
            if (root.left.left == null && root.left.right == null)
                sum += root.left.val;
            else
                // 还不是叶子节点，则继续遍历左子树
                sum += sumOfLeftLeaves(root.left);
        }

        // 遍历右子树
        sum += sumOfLeftLeaves(root.right);

        return sum;
    }
}
```
分析：
- Time complexity：O(n)

[title]:https://leetcode.com/problems/sum-of-left-leaves/