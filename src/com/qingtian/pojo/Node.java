package com.qingtian.pojo;

import java.util.List;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/5
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
