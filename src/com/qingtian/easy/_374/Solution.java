package com.qingtian.easy._374;

import com.qingtian.pojo.GuessGame;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/6/25
 */
public class Solution extends GuessGame {

    public int guessNumber(int n) {

        if (n < 0)
            throw new IllegalArgumentException();

        int left = 1, right = n;
        while (left <= right) {

            int mid = left + (right - left) / 2;
            if (guess(mid) == 0)
                return mid;
            else if (guess(mid) == 1)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }


}
