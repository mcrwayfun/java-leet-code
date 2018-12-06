# [Average of Levels in Binary Tree][title]

## Description

Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

**Example 1:**

```
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
```

**Tags:** Tree 

## 解读题意

## 思路1
BFS

```java
class Solution {
    
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> doubleList = new ArrayList<>();
        if (root == null)
            return doubleList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            // 当前行的值的和
            double sum = 0.0d;
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            doubleList.add(sum / level);
        }

        return doubleList;
    }
}
```
time complexity：O（n）


[title]:https://leetcode.com/problems/average-of-levels-in-binary-tree/