# [N-ary Tree Preorder Traversal][title]

## Description

Given an n-ary tree, return the preorder traversal of its nodes' values.

**Example 1:**

For example, given a 3-ary tree:


![](https://ws1.sinaimg.cn/large/0062R7s4gy1fxvp285ibrj30lp0dy0ta.jpg)

Return its preorder traversal as: [1,3,5,6,2,4].


**Tags:** Tree

## 解读题意
给定一个 N 叉树，返回其节点值的前序遍历。

## 思路1 


```java
class Solution {
   
    public List<Integer> preorder(Node root) {
        List<Integer> reList = new ArrayList<>();
    
        if (root == null)
            return reList;
    
        preorderHelper(root, reList);
        return reList;
    }
    
    private void preorderHelper(Node root, List<Integer> list) {
        if (root == null)
            return;
    
        list.add(root.val);
        for (Node node : root.children)
            preorderHelper(node, list);
    }
}
```

time complexity：O(n)


[title]: https://leetcode.com/problems/n-ary-tree-preorder-traversal/
