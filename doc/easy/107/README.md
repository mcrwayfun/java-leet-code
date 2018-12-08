# [Binary Tree Level Order Traversal II][title]

## Description

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).


**Example 1:**


```
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
 
return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]    
```

**Tags:** Tree

## 解读题意
从树的底部，对树进行层序遍历并输出

## 思路1 
使用BFS，因为要逆序输出，所以使用LinkedList（链表）的性质按顺序添加到下标为0的位置（时间复杂度为O（1））。


```java
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> retList = new LinkedList<>();
        if (root == null)
            return retList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();

                if (node != null && node.left != null)
                    queue.add(node.left);

                if (node != null && node.right != null)
                    queue.add(node.right);

                list.add(node.val);
            }
            retList.add(0, list);
        }

        return retList;
    }
}
```
time complexity:

[title]: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/