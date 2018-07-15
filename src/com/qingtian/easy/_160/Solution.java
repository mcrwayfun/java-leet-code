package com.qingtian.easy._160;

import com.qingtian.pojo.ListNode;
import com.qingtian.util.ListNodeUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/07/15
 * @description
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null)
            return null;

        Set<Integer> set = new HashSet<>();
        ListNode cur = headA;
        while (cur != null) {
            set.add(cur.val);
            cur = cur.next;
        }

        cur = headB;
        ListNode tmp = null;
        while (cur != null) {
            if (set.contains(cur.val)) {
                tmp = cur;
                break;
            }
            cur = cur.next;
        }

        return tmp;
    }

    public static void main(String[] args) {
        int[] arrayA = new int[]{1,3,5,7,9,11};
        int[] arrayB = new int[]{2,4,9,11};
        ListNode headA = ListNodeUtil.createList(arrayA);
        ListNode headB = ListNodeUtil.createList(arrayB);
        ListNode intersectionNode = new Solution().getIntersectionNode(headA, headB);
        ListNodeUtil.print(intersectionNode);
    }
}
