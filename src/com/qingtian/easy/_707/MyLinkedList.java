package com.qingtian.easy._707;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/13
 */
public class MyLinkedList {


    class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

    // 虚拟头节点
    private Node dummyHead;

    // 节点数
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        dummyHead = new Node(-1);
        size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        Node node = node(index);
        if (node == null)
            return -1;
        else
            return node.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {

        if (index < 0 || index > size)
            return;

        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        prev.next = new Node(val, prev.next);
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {

        if (index < 0 || index >= size)
            return;

        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        prev.next = prev.next.next;
        size--;
    }

    /**
     * 返回index对应的节点，若不存在则返回null
     *
     * @param index 下标
     * @return
     */
    private Node node(int index) {

        if (isEmpty())
            return null;

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;

        return cur;
    }

    /**
     * 判断列表是否为空
     *
     * @return
     */
    private boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkedList=[");
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL]");

        return res.toString();
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();

        linkedList.addAtHead(1);
        System.out.println("addAtHead(1):" + linkedList);

        linkedList.addAtTail(3);
        System.out.println("addAtTail(3):" + linkedList);

        linkedList.addAtIndex(1, 2);
        System.out.println("addAtIndex(1,2):" + linkedList);

        int val = linkedList.get(1);
        System.out.println("get(1):" + val);

        linkedList.deleteAtIndex(1);
        System.out.println("deleteAtIndex(1):" + linkedList);

        val = linkedList.get(1);
        System.out.println("get(1):" + val);
    }
}
