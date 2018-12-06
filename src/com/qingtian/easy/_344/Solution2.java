package com.qingtian.easy._344;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/5/22
 */
public class Solution2 {


    public String reverseString(String s) {
        StringBuffer sb = new StringBuffer(s);
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        String s = "hello";
        String result = new Solution2().reverseString(s);
        System.out.println(result);
    }
}
