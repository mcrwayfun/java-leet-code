# [Merge Two Sorted Lists][title]

## Description
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

**Example1:**
```
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
```

**Tags:** LinkedList

## 解读题意
将两个链表合并成一个新的链表，正序排列且不能丢失元素。

## 思路1 
1. 创建一个新链表，循环判断l1和l2的大小，将其拼接在新链表中。
![](https://i.imgur.com/hLyZOnC.jpg)
![](https://i.imgur.com/rNkWlYC.jpg)

```java
class Solution { 
    
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
                ListNode dummy = new ListNode(-1), cur = dummy;
                while (l1 != null && l2 != null) {
                    if (l1.val < l2.val) {
                        cur.next = l1;
                        l1 = l1.next;
                    } else {
                        cur.next = l2;
                        l2 = l2.next;
                    }
                    cur = cur.next;
                }
                cur.next = (l1 != null) ? l1 : l2;
                return dummy.next; 
        }
}
```

[title]: https://leetcode.com/problems/merge-two-sorted-lists/description/