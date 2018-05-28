# [Remove Nth Node From End of List][title]

## Description
Given a linked list, remove the n-th node from the end of list and return its head.

**Example1:**
```
Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
```

**Tags:** LinkedList

## 解读题意
删除单向链表的倒数第n个节点

## 思路1 
1. 定义两个节点，其中一个为runner，一个为walker。runner走到了第n个位置。这时walker和runner一起走，走到了runner没有后继节点，此时walker就是倒数第n个位置。
```java
class Solution { 
  
        static class ListNode {
             int val;
             ListNode next;
     
             ListNode(int x) {
                 val = x;
             }
         }
     
         public ListNode removeNthFromEnd(ListNode head, int n) {
             if (head == null)
                 return null;
             int i = 0;
             ListNode runner = head;
             while (runner != null && i < n) {
                 runner = runner.next;
                 i++;
             }
             if (i < n)
                 return head;
             if (runner == null)
                 return head.next;
             ListNode walker = head;
             while (runner.next != null) {
                 walker = walker.next;
                 runner = runner.next;
             }
             walker.next = walker.next.next;
             return head;
         }

}
```

[title]: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/