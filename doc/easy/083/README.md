# [Remove Duplicates from Sorted List][title]

## Description

Given a sorted linked list, delete all duplicates such that each element appear only once.

**Example 1:**

```
Input: 1->1->2
Output: 1->2
```
**Example 2:**

```
Input: 1->1->2->3->3
Output: 1->2->3
```


**Tags:** Linked List


## 解读题意
给出一个已经排好序的单链表，链表中可能存在重复的元素，删除这些重复的元素，即每个元素仅能出现一次。

## 思路1 
遍历链表，若存在重复的元素，则删除。比如现在有一个链表为**1->1->1->3->3**。进入循环中，当前current指向首位元素1，因为与后续的1相等，则执行`current.next = current.next.next`，第一个1指向到了第三个1；继续循环，当前current仍在首位元素1，因为与后续的1（第三个1）相等，所以第一个1指向到了2。此时再进入循环，首位元素1与2不想等，所以`current = current.next`，当前current指向了2。循环结束得出链表为**1->3**

```java
class Solution { 
  
 	 public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode current = head;
        while (current != null && current.next != null) {

            if (current.val == current.next.val)
                current.next = current.next.next;
            else
                current = current.next;
        }

        return head;
    }

}
```
分析：
- Time complexity：O(n)

[title]: https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/