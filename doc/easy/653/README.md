# [Two Sum IV - Input is a BST][title]

## Description

Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

**Example 1:**

```
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
```

**Example 2:**
```
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
```

**Tags:** Tree 

## 解读题意
在BST中找到是否有两个节点相加等于目标数target

## 思路1
定义一个HashSet，在遍历中判断

```java
class Solution {
    
    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;

        HashSet<Integer> set = new HashSet<>();
        return findTargetHelper(root, k, set);
    }

    private boolean findTargetHelper(TreeNode root, int k, HashSet<Integer> set) {
        if (root == null)
            return false;

        if (set.contains(k - root.val))
            return true;
        else
            set.add(root.val);

        return findTargetHelper(root.left, k, set) || findTargetHelper(root.right, k, set);
    }
}
```
time complexity：O（n）


[title]:https://leetcode.com/problems/two-sum-iv-input-is-a-bst/