package com.qingtian.easy._876;

import com.qingtian.pojo.ListNode;
import com.qingtian.util.ListNodeUtil;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/13
 */
public class Solution {

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // 定义快慢指针
        ListNode fast = head;
        ListNode slow = head;

        // 快指针每次走两步而慢指针每次走一步
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNodeUtil.createList(new int[]{1, 2, 3, 4, 5, 6});
        ListNode middleNode = new Solution().middleNode(listNode);
        ListNodeUtil.print(middleNode);
    }
}
