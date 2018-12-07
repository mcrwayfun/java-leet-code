# [N-ary Tree Level Order Traversal][title]

## Description

Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).


**Example 1:**

For example, given a 3-ary tree:


![](https://ws1.sinaimg.cn/large/0062R7s4gy1fxvp285ibrj30lp0dy0ta.jpg)

We should return its level order traversal:

[
​     [1],
​     [3,2,4],
​     [5,6]
]

**Note**

1. The depth of the tree is at most 1000.
2. The total number of nodes is at most 5000.

**Tags:** Tree

## 解读题意
BFS

## 思路1 

```java
class Solution {
    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> reList = new ArrayList<>();
        if (root == null)
            return reList;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 当前层存在多少个元素
            int level = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                Node add = queue.poll();
                if (add != null) {
                    list.add(add.val);
                    queue.addAll(add.children);
                }
            }

            reList.add(list);
        }

        return reList;
    }
}
```
分析：
- Time complexity：


[title]:https://leetcode.com/problems/n-ary-tree-level-order-traversal/