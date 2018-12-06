package com.qingtian.easy._234;

import com.qingtian.pojo.ListNode;

import java.util.LinkedList;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/05/31
 */
public class Solution {


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


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(2);
        ListNode head4 = new ListNode(1);

        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;

        boolean palindrome = new Solution().isPalindrome(head);

    }

}
