package com.qingtian.pojo;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/05/30
 */
public class ListNode {


    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public void print() {
        ListNode current = this;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
