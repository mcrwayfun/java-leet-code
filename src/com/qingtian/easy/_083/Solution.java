package com.qingtian.easy._083;

import com.qingtian.pojo.ListNode;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/07/13
 * @description
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode current = head;
        while (current != null && current.next != null) {

            if (current.val == current.next.val)
                current.next = current.next.next;
            else
                current = current.next;
        }

        return head;
    }


}
