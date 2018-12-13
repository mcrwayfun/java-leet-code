package com.qingtian.util;

import com.qingtian.pojo.ListNode;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/07/15
 * @description
 */
public class ListNodeUtil {

    /**
     * 输出一个单链表
     *
     * @param node
     */
    public static void print(ListNode node) {

        StringBuilder res = new StringBuilder();
        res.append("ListNode=[");
        ListNode current = node;
        while (current != null) {
            res.append(current.val + "->");
            current = current.next;
        }
        res.append("Null]");
        System.out.println(res.toString());
    }

    /**
     * 创建一个单链表
     *
     * @param array 输入数组
     * @return
     */
    public static ListNode createList(int[] array) {

        ListNode head = null;
        for (int i = 0; i < array.length; i++) {
            int val = array[i];
            head = add(head, val);
        }

        return head;
    }

    private static ListNode add(ListNode head, int data) {

        ListNode insNode = new ListNode(data);
        if (head == null) {
            head = insNode;
            return head;
        }

        ListNode temp = head;
        ListNode cur = null;
        while (temp != null) {
            cur = temp;
            temp = temp.next;
        }
        cur.next = insNode;

        return head;
    }
}
