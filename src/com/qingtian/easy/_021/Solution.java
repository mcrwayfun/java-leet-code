package com.qingtian.easy._021;

import com.qingtian.pojo.ListNode;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/05/30
 */
public class Solution {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1), cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);

        ListNode listNode = new Solution().mergeTwoLists(l1, l2);
    }
}
