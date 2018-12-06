# [Palindrome Linked List][title]

## Description
Given a singly linked list, determine if it is a palindrome.

**Example1:**
```
Input: 1->2
Output: false
```

**Example2:**
```
Input: 1->2->2->1
Output: true
```

**Tags:** LinkedList

## 解读题意
判断该链表是不是回文链表

## 思路1 
1. 定义一个stack，将链表中所有元素压入栈中。
2. 遍历链表，比较pop出来的元素与当前的val值是否相等，若想等则是回文。
该方法申明了stack，使用了额外的存储空间。

```java
class Solution { 
  
       public boolean isPalindrome(ListNode head) {
        LinkedList temp = new LinkedList();
        ListNode cur = head;
        while (cur != null) {
            temp.push(cur.val);
            cur = cur.next;
        }

        while (head != null) {
            if (head.val != (int) temp.pop()) {
                return false;
            }
            head = head.next;
        }

        return true;
    }

}
```

## 思路2
1. 定义两个指针fast和slow。当fast走到链表的末尾，slow刚好处于链表的中间位置。
2. 判断fast是否为null，若为null则表明链表长度为偶数；否则链表长度为奇数，`slow = slow.next`（不比较中间数）
3. 反转链表的后半部分（slow开始）
4. 链表的前半部分和反转后的reserve比较，若存在值不同则不是回文链表，返回`false`。

```java
class Solution { 
  
      public boolean isPalindrome(ListNode head) {

        // 快慢指针和存储中间节点
        ListNode fast = head, slow = head;

        if (head != null && head.next != null) {

            while (fast != null && fast.next != null) {

                fast = fast.next.next;
                slow = slow.next;
            }

            // 若fast不为null，则说明head长度为奇数
            if (fast != null) {
                slow = slow.next;
            }

            ListNode reserve = reserve(slow);
            // head的前半部分
            ListNode perv = head;
            while (reserve != null) {
                if (perv.val != reserve.val) {
                    return false;
                }
                perv = perv.next;
                reserve = reserve.next;
            }

        }

        return true;
    }

    private ListNode reserve(ListNode head) {
        ListNode cur = head, prev = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        head = prev;
        return head;
    }
}
```
[title]: https://leetcode.com/problems/palindrome-linked-list/description/