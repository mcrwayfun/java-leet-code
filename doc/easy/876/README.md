# [Middle of the Linked List][title]

## Description

Given a non-empty, singly linked list with head node head, return a middle node of linked list.

If there are two middle nodes, return the second middle node.

**Example1**
```
Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
```

**Example2**
```
Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.
```


**Tags:** Linked List

## 解读题意


## 思路1 
快慢指针

```java
class Solution {
    
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // 定义快慢指针
        ListNode fast = head;
        ListNode slow = head;

        // 快指针每次走两步而慢指针每次走一步
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

}
```
time complexity:O(n)


[title]: https://leetcode.com/problems/middle-of-the-linked-list/