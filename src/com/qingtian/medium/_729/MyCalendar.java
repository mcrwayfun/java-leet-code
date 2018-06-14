package com.qingtian.medium._729;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/6/14
 */
public class MyCalendar {


    // TreeMap<Integer, Integer> tmap = new TreeMap<>();
    // public MyCalendar() {
    //
    // }
    //
    // public boolean book(int start, int end) {
    //
    //     Map.Entry<Integer, Integer> floorEntry = tmap.floorEntry(start);
    //     Map.Entry<Integer, Integer> ceilingEntry = tmap.ceilingEntry(start);
    //
    //     if (floorEntry != null && floorEntry.getValue() > start)
    //         return false;
    //
    //     if (ceilingEntry != null && ceilingEntry.getKey() < end)
    //         return false;
    //
    //     tmap.put(start, end);
    //     return true;
    // }

//    TreeMap tm;
//
//    public MyCalendar() {
//        tm = new TreeMap<Integer, Integer>();
//    }
//
//    public boolean book(int start, int end) {
//        Map.Entry<Integer, Integer> entry = tm.lowerEntry(end);
//        if (entry != null && entry.getValue() > start) return false;
//        tm.put(start, end);
//        return true;
//    }

    //节点有起始结束时间和左右子节点
    class Node {

        public Node(int start, int end) {
            l = start;
            r = end;
        }

        int l, r;
        Node left, right;
    }

    Node root = null;

    public boolean book(int start, int end) {
        if (root == null) {
            root = new Node(start, end);
        } else {
            Node cur = root;
            //父节点
            Node pre = null;
            //记录该插入的节点是左子还是右子
            boolean leftTag = false;
            while (cur != null) {
                pre = cur;
                //应该在当前节点的左侧，往左子递归
                if (end <= cur.l) {
                    leftTag = true;
                    cur = cur.left;
                }
                //应该在当前节点的右侧，往右子递归
                else if (start >= cur.r) {
                    leftTag = false;
                    cur = cur.right;
                }
                // 有重叠，不应该插入，返回false
                else {
                    return false;
                }
            }
            //根据tag确定是父亲的左子还是右子
            if (leftTag) {
                pre.left = new Node(start, end);
            } else {
                pre.right = new Node(start, end);
            }
        }
        return true;

    }

    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar();
        boolean book = calendar.book(10, 20);
        System.out.println("first:(10,20) " + book);
        boolean book1 = calendar.book(25, 35);
        System.out.println("second:(25,35) " + book1);
        boolean book2 = calendar.book(36, 38);
        System.out.println("second:(36,38) " + book2);
    }
}
