package com.qingtian.medium._725;

import com.qingtian.pojo.ListNode;
import com.qingtian.util.ListNodeUtil;

import java.util.Arrays;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/7/16
 */
public class Solution {

    public ListNode[] splitListToParts(ListNode root, int k) {

        int length = 0;
        ListNode cur = root;
        while (cur != null) {
            cur = cur.next;
            length++;
        }

        ListNode[] listNodes = new ListNode[k];

        // 每个区间listNode个数
        int size = length / k;
        // 多余的listNode
        int extra = length % k;
        cur = root;
        for (int i = 0; i < k && cur != null; i++) {
            listNodes[i] = cur;
            // size + ((extra > 0) ? 1 : 0)
            // 每个区间长度之间相差不可超过1
            for (int j = 1; j < size + ((extra > 0) ? 1 : 0); j++)
                cur = cur.next;
            // 切断当前的listNode
            ListNode temp = cur.next;
            cur.next = null;
            // 下一个区间的开始
            cur = temp;
            // 没用掉一个多余的便减去
            extra--;
        }

        return listNodes;
    }

    public static void main(String[] args) {
        ListNode root = ListNodeUtil.createList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        int k = 3;
        ListNode[] listNodes = new Solution().splitListToParts(root, k);
    }
}
