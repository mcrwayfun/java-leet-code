# [Minimum Distance Between BST Nodes][title]

## Description

Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.

**Example 1:**

```
Input: root = [4,2,6,1,3,null,null]
Output: 1
Explanation:
Note that root is a TreeNode object, not an array.

The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

          4
        /   \
      2      6
     / \    
    1   3  

while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
```

**Tags:** Tree

## 解读题意
给定一个查找二叉树，找出该树中结点与结点间相减的最小值。

## 思路1 
用中序遍历得到一个有序的数组，遍历数组找出相邻最小值即可。

```java
class Solution {
    
    public int minDiffInBST(TreeNode root) {

        List<Integer> tempList = new ArrayList<>();

        int distance = Integer.MAX_VALUE;
        minDiffInBSTHelper(root,tempList);

        for (int i = 1; i < tempList.size(); i++) {
            distance = Math.min(distance,tempList.get(i)-tempList.get(i-1));
        }

        return distance;
    }

	 private void minDiffInBSTHelper(TreeNode root, List<Integer> vals) {

        if (root == null)
            return;

        minDiffInBSTHelper(root.left, vals);
        vals.add(root.val);
        minDiffInBSTHelper(root.right, vals);

    }

}
```
time complexity:O(n)

## 思路2
与思路1一致，但是可以通过定义两个类变量而不用创建数组。

```java
public class Solution1 {

    private int distance = Integer.MAX_VALUE;

    private Integer pre ;

    public int minDiffInBST(TreeNode root) {
        pre = null;

        if (root == null)
            return 0;

        minDiffInBSTHelper(root);

        return distance;
    }

    private void minDiffInBSTHelper(TreeNode root) {

        if (root == null)
            return;

        minDiffInBSTHelper(root.left);
        if(pre != null)
            distance = Math.min(distance, root.val - pre);

        pre = root.val;
        minDiffInBSTHelper(root.right);
    }

}
```
time complexity:O(n)

[title]: https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/