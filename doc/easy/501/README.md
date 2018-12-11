# [Find Mode in Binary Search Tree][title]

## Description

Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

- The left subtree of a node contains only nodes with keys less than or equal to the node's key.
- The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
- Both the left and right subtrees must also be binary search trees.

**Note:** If a tree has more than one mode, you can return them in any order.

**Follow up:** Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

**Example 1:**

```
Given BST [1,null,2,2],

   1
    \
     2
    /
   2
 

return [2].
```

**Tags:** Tree

## 解读题意
找出BST中出现次数最多的值（解法使用了额外的空间）
## 思路1 

```java
class Solution {
    
    private Map<Integer, Integer> map;

    private int max = 0;

    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[]{};

        map = new HashMap<>();
        midOrder(root);

        // 遍历获取出现次数最多的value
        List<Integer> tempList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max == entry.getValue())
                tempList.add(entry.getKey());
        }

        // 输出到int[]中
        int[] ret = new int[tempList.size()];
        for (int i = 0; i < tempList.size(); i++)
            ret[i] = tempList.get(i);

        return ret;
    }

    private void midOrder(TreeNode root) {
        if (root == null)
            return;

        midOrder(root.left);

        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        max = Math.max(max, map.get(root.val));

        midOrder(root.right);
    }
}
```
time complexity:O(n)
space complexity:O(n)

[title]: https://leetcode.com/problems/find-mode-in-binary-search-tree/