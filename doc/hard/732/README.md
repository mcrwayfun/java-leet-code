# [My Calendar III][title]

## Description

Implement a MyCalendarThree class to store your events. A new event can always be added.

Your class will have one method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.

A K-booking happens when K events have some non-empty intersection (ie., there is some time that is common to all K events.)

For each call to the method MyCalendar.book, return an integer K representing the largest integer such that there exists a K-booking in the calendar.

Your class will be called like this: MyCalendarThree cal = new MyCalendarThree(); MyCalendarThree.book(start, end)

**Note**
- The number of calls to MyCalendarThree.book per test case will be at most 400.
- In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].

**Example 1:**

```
MyCalendarThree();
MyCalendarThree.book(10, 20); // returns 1
MyCalendarThree.book(50, 60); // returns 1
MyCalendarThree.book(10, 40); // returns 2
MyCalendarThree.book(5, 15); // returns 3
MyCalendarThree.book(5, 10); // returns 3
MyCalendarThree.book(25, 55); // returns 3
Explanation: 
The first two events can be booked and are disjoint, so the maximum K-booking is a 1-booking.
The third event [10, 40) intersects the first event, and the maximum K-booking is a 2-booking.
The remaining events cause the maximum K-booking to be only a 3-booking.
Note that the last event locally causes a 2-booking, but the answer is still 3 because
eg. [10, 20), [10, 40), and [5, 15) are still triple booked.
```

**Tags:** Tree

## 解读题意
是My Calendar I，My Calendar II升级版，判断存在的重叠区域的最大个数

## 思路1 
定义一个TreeMap，其中key为时间点，value为时间点出现次数，使时间点和次数之间形成映射。假设加入的区间为[start,end)，规定每当遇到start，次数加1，遇到end，次数-1。example中的区间按照规则展示，如下图所示：

![](https://i.imgur.com/ZRkwIe7.png)

1. 将`start`或者`end`作为key，出现次数作为value存入map中
2. 用一个变量count来统计出现的`k-booking`，遍历map，比较得出count

```java
public class MyCalendarThree {

    private TreeMap<Integer, Integer> counts = new TreeMap<>();

    public MyCalendarThree() {

    }

    public int book(int start, int end) {

        counts.put(start, counts.getOrDefault(start, 0) + 1);
        counts.put(end, counts.getOrDefault(end, 0) - 1);

        int count = 0, curr = 0;
        for (int index : counts.values()) {
            count = Math.max(count, curr += index);
        }

        return count;
    }
}
```
time complexity:O(n^2)。

[title]: https://leetcode.com/problems/my-calendar-iii/description/