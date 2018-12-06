# [N-ary Tree Postorder Traversal][title]

## Description

Given an n-ary tree, return the postorder traversal of its nodes' values.

**Example 1:**

For example, given a 3-ary tree:


![](https://ws1.sinaimg.cn/large/0062R7s4gy1fxvp285ibrj30lp0dy0ta.jpg)

Return its postorder traversal as: [5,6,3,2,4,1].


**Tags:** Tree

## 解读题意
给定一个 N 叉树，返回其节点值的后序遍历。

## 思路1 


```java
class Solution {
   
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        postorderHelper(root, list);
        return list;
    }

    private void postorderHelper(Node root, List<Integer> list) {
        if (root == null)
            return;

        for (Node node : root.children)
            postorderHelper(node, list);

        list.add(root.val);
    }
}
```

time complexity：O(n)


[title]: https://leetcode.com/problems/n-ary-tree-postorder-traversal/
