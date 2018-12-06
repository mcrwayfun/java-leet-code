package com.qingtian.easy._019;

import com.qingtian.pojo.ListNode;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/5/28
 */
public class Solution {


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

    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode head = new Solution().removeNthFromEnd(node1, 2);
    }
}
