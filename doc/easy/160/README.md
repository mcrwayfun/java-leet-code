# [Intersection of Two Linked Lists][title]

## Description

Write a program to find the node at which the intersection of two singly linked lists begins.

**Example 1:**

```
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3

begin to intersect at node c1.
```

**Note:**

- If the two linked lists have no intersection at all, return null.
- The linked lists must retain their original structure after the function returns.
- You may assume there are no cycles anywhere in the entire linked structure.
- Your code should preferably run in O(n) time and use only O(1) memory.

**Tags:** Linked List


## 解读题意
找出两个单向链表中重合的地方，若存在，则返回重合开始的节点；若不存在，则返回null

## 思路1 
1. 遍历headA，用一个Set来存储出现过的值
2. 遍历headB，判断当前值是否在Set中出现，若有，则直接返回当前指针

```java
class Solution { 
  
 	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null)
            return null;

        Set<Integer> set = new HashSet<>();
        ListNode cur = headA;
        while (cur != null) {
            set.add(cur.val);
            cur = cur.next;
        }

        cur = headB;
        ListNode tmp = null;
        while (cur != null) {
            if (set.contains(cur.val)) {
                tmp = cur;
                break;
            }
            cur = cur.next;
        }

        return tmp;
    }

}
```
分析：
- Time complexity：O(n)或者O(m)
- Space complexity：O(n)

## 思路2
题目说了两个链表中不存在回环，所以可以使用环的思想来找出是否重合：让两个链表分别各自从链表头遍历到链表尾，当其中一个链表遍历结束，则跳到另外一个链表继续访问，当两个指针a和b相等时结束遍历。这样可能会出现两种结果。一种是在各自的末尾空节点相遇，即没有遇到重合的节点。为什么会相遇呢，因为两个指针走过的路程是相等的，都是m+n。第二种则是遇到重合的节点，提早退出了循环


```java
class Solution { 
  
 	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null)
            return null;

        ListNode a = headA, b = headB;
        while (a != b) {

            if (a != null && b != null && a.val == b.val)
                return a;

            a = (a != null) ? a.next : headB;
            b = (b != null) ? b.next : headA;
        }

        return a;

    }

}
```
分析：
- Time complexity：O(n+m)
- Space complexity：O(1)

[title]: https://leetcode.com/problems/intersection-of-two-linked-lists/description/