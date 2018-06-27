# [4Sum II][title]

## Description

Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

**Example 1:**

```
Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

Output:
2

Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
```

**Tags:** Hash Table

## 解读题意
给出ABCD4个数组，计算出有多少个` (i, j, k, l)`能够使表达式 `A[i] + B[j] + C[k] + D[l] =0` 成立的组合

## 思路1 

![](https://i.imgur.com/8xV3Hnu.png)
1. 定义两个map，分别用来存储`key=A[i] + B[j],value=A[i] + B[j]出现次数`，`key=C[k] + D[l]，value=A[i] + B[j]出现次数`
2. 遍历m1，因为`x+(-x)=0`成立。x为map1的key，设-x即为其相反值，若`m2.containsKey(-x)`成立，则符合表达式`A[i] + B[j] + C[k] + D[l] =0`，结果集`res += m1.get(x) * m2.get(-x)`；否则`res += 0`

如上图所示，ABCD数组分为A[-1,-1]、B[-1,1]、C[-1,1]、D[1,-1]，则`A[i]+B[j]`可能出现的值为0、-2，出现次数为2、2，为了方便，我们用(0,2),(-2,2)来表示。同理，`C[k] + D[l]`可以表示为(0,2),(-2,1),(2,1)。当m1的entry为(0,2)时，m2的entry为(0,2)符合`0+0=0`，所以此时res = 2*2=4，同理可以算出res=6

```java
public class Solution {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        if (A.length != B.length || B.length != C.length || C.length != D.length
                || A.length == 0)
            return 0;


        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();

        // 默认数组ABCD有共同的length
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m1.put(A[i] + B[j], m1.getOrDefault(A[i] + B[j], 0) + 1);
                m2.put(C[i] + D[j], m2.getOrDefault(C[i] + D[j], 0) + 1);
            }
        }

        int res = 0;

        for (int x : m1.keySet()) {
            res += m2.containsKey(-x) ? m1.get(x) * m2.get(-x) : 0;
        }

        return res;
    }
}
```
time complexity:O(n^2)。


[title]: https://leetcode.com/problems/4sum-ii/description/