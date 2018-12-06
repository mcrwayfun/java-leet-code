# [Increasing Order Search Tree][title]

## Description

Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.

**Example1**

Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
​       5
​      / \
​    3    6
   / \    \
  2   4    8
 /        / \ 
1        7   9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
  \
   2
​    \
​     3
​      \
​       4
​        \
​         5
​          \
​           6
​            \
​             7
​              \
​               8
​                \
​                 9  


**Tags:** Tree

## 解读题意


## 思路1 
中序遍历操作

```java
class Solution {
    
    // 当前指针
    private TreeNode last;
    private TreeNode newRoot;
	
    public TreeNode increasingBST(TreeNode root) {
        helper(root);
        return newRoot;
    }
    
    private void helper(TreeNode root){
        if(root == null)
            return;
        
        helper(root.left);
        if(last == null){
            last = root;
            newRoot = root;
        }else{
            last.right = root;
            last = root;
            last.left = null;
        }
        helper(root.right);
    }
}
```
time complexity：O(lgn)


[title]: https://leetcode.com/problems/increasing-order-search-tree/