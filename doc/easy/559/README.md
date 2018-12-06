# [Maximum Depth of N-ary Tree][title]

## Description

Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

**Example 1:**

`For example, given a 3-ary tree:
 
 ![](https://ws1.sinaimg.cn/large/0062R7s4gy1fxvp285ibrj30lp0dy0ta.jpg)
 
 We should return its max depth, which is 3.

**Tags:** Tree

## 解读题意
找出树的最大深度

## 思路1 

```java
class Solution {
    
    public int maxDepth(Node root) {
        if (root == null)
            return 0;

        int maxDepth = 0;
        for (Node node : root.children)
            if (node.children != null)
                maxDepth = Math.max(maxDepth, maxDepth(node));

        return maxDepth + 1;
    }
}
```
time complexity:O(n)


[title]: https://leetcode.com/problems/maximum-depth-of-n-ary-tree/