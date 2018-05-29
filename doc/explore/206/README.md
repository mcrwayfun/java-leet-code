# [Reverse a singly linked list][title]

## Description
Given a linked list, remove the n-th node from the end of list and return its head.

**Example1:**
```
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
```

**Tags:** LinkedList

## 解读题意
翻转单向链表

## 思路1 
![](https://i.imgur.com/kBiACxg.jpg)
1. 保存head下一节点
2. 将head所指向的下一节点改为prev
3. prev替换为head
4. 将第一步保存的下一节点替换为head，用于下次循环

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

[title]: https://leetcode.com/problems/reverse-linked-list/description/