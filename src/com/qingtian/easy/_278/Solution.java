package com.qingtian.easy._278;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/06/09
 */
public class Solution {

    private boolean isBadVersion(int version) {
        return true;
    }

    public int firstBadVersion(int n) {

        int left = 1;
        int right = n;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            if (isBadVersion(mid))
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left;

    }


}
