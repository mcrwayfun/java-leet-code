package com.qingtian.easy._141;

import com.qingtian.pojo.ListNode;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/6/1
 */
public class Solution {


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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);

        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head2;

        new Solution().hasCycle(head);

    }
}
