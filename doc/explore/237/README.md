# [Delete Node in a Linked List][title]

## Description

Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.


**Tags:** LinkedList


## 解读题意
删除单向链表的节点

## 思路1 
1. 将要被删除节点的后继节点的数据复制到当前节点，删除后继节点就行
```java
class Solution { 
  
      static class ListNode {
          int val;
          ListNode next;
  
          ListNode(int x) {
              val = x;
          }
      }
  
      public void deleteNode(ListNode node) {
          node.val = node.next.val;
          node.next = node.next.next;
      }

}
```

[title]: https://leetcode.com/problems/delete-node-in-a-linked-list/description/