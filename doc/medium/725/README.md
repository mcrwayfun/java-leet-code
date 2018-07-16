# [Split Linked List in Parts][title]

## Description

Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".

The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.

The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.

Return a List of ListNode's representing the linked list parts that are formed.

**Example 1:**

```
Input: 
root = [1, 2, 3], k = 5
Output: [[1],[2],[3],[],[]]
Explanation:
The input and each element of the output are ListNodes, not arrays.
For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
The first element output[0] has output[0].val = 1, output[0].next = null.
The last element output[4] is null, but it's string representation as a ListNode is [].
```

**Example 2:**

```
Input: 
root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
Explanation:
The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
```

**Tags:** Linked List

## 解读题意
给出一个单链表，把链表划分成k个部分，划分的规则如下：
- 划分为k个连续的区间，且每个区间长度相差不能超过1
- 空区间的值为null
- 区间长度大的放于前面

## 思路1 
1. 计算出链表的长度length
2. 计算每个区间listNode个数：`length / k`，多余的listNode个数，即求余：`length % k`

```java
public class Solution {

     public ListNode[] splitListToParts(ListNode root, int k) {

        int length = 0;
        ListNode cur = root;
        while (cur != null) {
            cur = cur.next;
            length++;
        }

        ListNode[] listNodes = new ListNode[k];

        // 每个区间listNode个数
        int size = length / k;
        // 多余的listNode
        int extra = length % k;
        cur = root;
        for (int i = 0; i < k && cur != null; i++) {
            listNodes[i] = cur;
            // size + ((extra > 0) ? 1 : 0)
            // 每个区间长度之间相差不可超过1
            for (int j = 1; j < size + ((extra > 0) ? 1 : 0); j++)
                cur = cur.next;
            // 切断当前的listNode
            ListNode temp = cur.next;
            cur.next = null;
            // 下一个区间的开始
            cur = temp;
            // 没用掉一个多余的便减去
            extra--;
        }

        return listNodes;
    }
}
```
time complexity：O(n+k)，k是远小于n的。

[title]: https://leetcode.com/problems/split-linked-list-in-parts/description/