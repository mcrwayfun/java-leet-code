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
  
        public ListNode reverseList(ListNode head) {
                ListNode prev = null;
                ListNode curr = head;
                while (curr != null) {
                    ListNode temp = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = temp;
                }
                // fix head
                head = prev;
        
                return head; 
        }

}
```

[title]: https://leetcode.com/problems/reverse-linked-list/description/