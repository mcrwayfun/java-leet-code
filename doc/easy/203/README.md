# [Remove Linked List Elements][title]

## Description

Remove all elements from a linked list of integers that have value val.

**Example 1:**

```
Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
```

**Tags:** Linked List


## 解读题意
移除链表中指定的元素

## 思路1 
1. 定义一个新的节点newHead作为头元素，并且`newHead.next = head`，定义pre（用来保留上一个节点）指向新的头元素newHead，current（当前节点）指向head
2. 如果`current.val == val`，就移除当前元素，即current；否则pre指向当前元素
3. 当前元素current后移，`current = current.next`

![](https://i.imgur.com/S09w9iN.png)

```java
class Solution { 
  
    public ListNode removeElements(ListNode head, int val) {

        ListNode newHead = new ListNode(val - 1);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode current = head;
        while (current != null) {

            if (current.val == val)
                pre.next = current.next;
            else
                pre = current;

            current = current.next;
        }

        return newHead.next;
    }

}
```
分析：
- Time complexity：O(n)

[title]: https://leetcode.com/problems/remove-linked-list-elements/description/