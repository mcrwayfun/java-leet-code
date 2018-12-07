package com.qingtian.easy._606;

import com.qingtian.pojo.TreeNode;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/7
 */
public class Solution {

    public String tree2str(TreeNode t) {
        if (t == null)
            return "";

        String result = t.val + "";

        String left = tree2str(t.left);
        String right = tree2str(t.right);

        // left为空字符串
        if(left.equals("") && right.equals(""))
            return result;
        if (left.equals(""))
            return result + "()" + "(" + right + ")";
        if (right.equals(""))
            return result + "(" + left + ")";
        else
            return result + "(" + left + ")" + "(" + right + ")";
    }
}
