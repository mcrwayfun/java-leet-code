package com.qingtian.easy._203;

import com.qingtian.pojo.ListNode;
import com.qingtian.util.ListNodeUtil;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/07/14
 * @description
 */
public class Solution1 {


    public ListNode removeElements(ListNode head, int val) {

        ListNode current = head;
        ListNode prev = null;
        while (current != null) {

            if (current.val == val) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                current = current.next;
            } else {
                prev = current;
                current = current.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(6);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        ListNode head6 = new ListNode(6);

        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = head6;
        int val = 1;
        ListNode listNode = new Solution1().removeElements(head, val);
        ListNodeUtil.print(listNode);
    }
}
