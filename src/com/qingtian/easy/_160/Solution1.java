package com.qingtian.easy._160;

import com.qingtian.pojo.ListNode;
import com.qingtian.util.ListNodeUtil;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/07/15
 * @description
 */
public class Solution1 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null)
            return null;

        ListNode a = headA, b = headB;
        while (a != b) {

            if (a != null && b != null && a.val == b.val)
                return a;

            a = (a != null) ? a.next : headB;
            b = (b != null) ? b.next : headA;
        }

        return a;


    }

    public static void main(String[] args) {
        int[] arrayA = new int[]{1, 3, 5, 7, 9, 11};
        int[] arrayB = new int[]{2, 4, 9, 11};
        ListNode headA = ListNodeUtil.createList(arrayA);
        ListNode headB = ListNodeUtil.createList(arrayB);
        ListNode intersectionNode = new Solution1().getIntersectionNode(headA, headB);
        ListNodeUtil.print(intersectionNode);
    }

}
