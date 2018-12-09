# [Binary Tree Paths][title]

## Description

Given a binary tree, return all root-to-leaf paths.

**Example 1:**

```
Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
```

**note**
A leaf is a node with no children.

**Tags:** Tree


## 解读题意

## 思路1 

```java
class Solution { 
  
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> retList = new ArrayList<>();
        if (root == null)
            return retList;

        binaryTreePathsHelper(root, retList, "");
        return retList;
    }

    private void binaryTreePathsHelper(TreeNode root, List<String> list, String res) {
        if (root.left == null && root.right == null) {
            list.add(res + root.val);
            return;
        }

        res = res + root.val + "->";

        if (root.left != null)
            binaryTreePathsHelper(root.left, list, res);
        if (root.right != null)
            binaryTreePathsHelper(root.right, list, res);
    }

}
```
- Time complexity：O(n)

[title]: https://leetcode.com/problems/binary-tree-paths/