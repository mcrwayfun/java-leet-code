package com.qingtian.easy._234;

import com.qingtian.pojo.ListNode;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/05/31
 */
public class Solution1 {


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


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(2);
        ListNode head4 = new ListNode(1);

        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;

        boolean palindrome = new Solution1().isPalindrome(head);

    }

}
