# [Binary Tree Level Order Traversal][title]

## Description
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

**Example 1:**
For example, Given binary tree [3,9,20,null,null,15,7],
```
	3
   / \
  9  20
    /  \
   15   7
```
return its level order traversal as:
```
[
  [3],
  [9,20],
  [15,7]
]
```

**Tags:** Tree

## 解读题意
层序遍历一棵二叉树：从上到下，从左到右

## 思路1 
1. 根结点为空是空树，返回
2. 申明一个queue,将根结点放入
3. 若queue不为空，将根结点的左右结点放入队列中，将根结点从queue中弹出存入list中，此时队列中存放的就是下一层的所有结点
4. 重复执行步骤3知道queue为空

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        return levelOrderHelper(root);
    }

    private List<List<Integer>> levelOrderHelper(TreeNode root) {

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        List<List<Integer>> relist = new ArrayList<>();

        if (root == null)
            return relist;

        treeNodeQueue.offer(root);
        while (!treeNodeQueue.isEmpty()) {
            int levelSize = treeNodeQueue.size();
            List<Integer> subList = new LinkedList<>();
            while(levelSize != 0 ){
                if(treeNodeQueue.peek().left != null)treeNodeQueue.offer(treeNodeQueue.peek().left);
                if(treeNodeQueue.peek().right != null)treeNodeQueue.offer(treeNodeQueue.peek().right);
                levelSize--;
                subList.add(treeNodeQueue.poll().val);
            }
            relist.add(subList);
        }

        return relist;
    }
}
```
time complexity:O(n^2)

## 思路2
运用递归来求，但是算法核心和思路1是一致的
1. 按照前序遍历的顺序来访问二叉树，每访问一个结点，将当前结点的val放入list中。
2. 递归访问左右子结点，直到子结点为空

```java

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> relist = new ArrayList<>();
        if (root == null)
            return relist;

        levelOrderHelper(root, 0, relist);
        return relist;
    }

    private void levelOrderHelper(TreeNode root, int level, List<List<Integer>> relist) {

        if(root == null)
            return;

        if(relist.size() <= level)
            relist.add(new ArrayList<>());


        relist.get(level).add(root.val);
        levelOrderHelper(root.left,level+1,relist);
        levelOrderHelper(root.right,level+1,relist);

    }
```

time complexity:O(n)

[title]: https://leetcode.com/problems/binary-tree-level-order-traversal/description/