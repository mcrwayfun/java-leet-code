# [Linked List Cycle][title]

## Description
Given a linked list, determine if it has a cycle in it.


**Tags:** LinkedList

## 解读题意
判断该链表是不是存不存在环

## 思路1 
1. 定义两个指针，一个快一个慢。快指针每次移动两步，慢指针移动一步，若快慢指针在某处重合，则说明存在环。

```java
class Solution { 
  
    public boolean hasCycle(ListNode head) {

        ListNode fast = head, slow = head;

        if(head == null || head.next == null)
            return false;

        while(fast.next != null && fast.next.next != null){

            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return true;
        }

        return false;
    }

}
```

[title]: https://leetcode.com/problems/linked-list-cycle/description/