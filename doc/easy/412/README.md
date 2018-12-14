# [Fizz Buzz][title]

## Description

Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

**Example 1:**

```
n = 15,

Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]
```

**Tags:** Array

## 解读题意

```java
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> reList = new ArrayList<>();
        if (n <= 0)
            return reList;

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0)
                reList.add("FizzBuzz");
            else if (i % 5 == 0)
                reList.add("Buzz");
            else if (i % 3 == 0)
                reList.add("Fizz");
            else
                reList.add(String.valueOf(i));
        }

        return reList;
    }
}
```
分析：
- Time complexity：O(n)

[title]:https://leetcode.com/problems/fizz-buzz/