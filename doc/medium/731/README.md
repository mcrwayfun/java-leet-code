# [My Calendar II][title]

## Description

Implement a MyCalendarTwo class to store your events. A new event can be added if adding the event will not cause a triple booking.

Your class will have one method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.

A triple booking happens when three events have some non-empty intersection (ie., there is some time that is common to all 3 events.)

For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a triple booking. Otherwise, return false and do not add the event to the calendar.

Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)

**Note**
- The number of calls to MyCalendar.book per test case will be at most 1000.
- In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].

**Example 1:**

```
MyCalendar();
MyCalendar.book(10, 20); // returns true
MyCalendar.book(50, 60); // returns true
MyCalendar.book(10, 40); // returns true
MyCalendar.book(5, 15); // returns false
MyCalendar.book(5, 10); // returns true
MyCalendar.book(25, 55); // returns true
Explanation: 
The first two events can be booked.  The third event can be double booked.
The fourth event (5, 15) can't be booked, because it would result in a triple booking.
The fifth event (5, 10) can be booked, as it does not use time 10 which is already double booked.
The sixth event (25, 55) can be booked, as the time in [25, 40) will be double booked with the third event;
the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
```

**Tags:** Tree

## 解读题意
根据My Calendar I改编。My Calendar I是判断是否有区间重叠，而该题允许存在一个重叠区域，但不允许存在两个区域。

## 思路1 
如果有两个区间，分别是[s1,e1)、[s2,e2)和[s3,e3),如图：
![](https://i.imgur.com/QwLv79O.png)

分别有两个区间`overlaps`（存储重叠区域）和`booked`(存储正常event)
1. 判断是否有与`overlaps`重叠，如果有，则说明已经存在两个重叠区域，直接返回false
2. 判断新加入的event是否与`booked`中的event重叠（**如图中黄线到红线区域**），若有，则将重叠区域加入`overlaps`
3. 新的event加入`booked`

```java
public class MyCalendar {

    private List<int[]> overlaps = new ArrayList<>();
    private List<int[]> booked = new ArrayList<>();

    public boolean book(int start, int end) {

        for (int[] val : overlaps)
            if (Math.max(start, val[0]) < Math.min(end, val[1]))
                return false;

        for (int[] val : booked) {
            int ss = Math.max(start, val[0]);
            int ee = Math.min(end, val[1]);
            if (ss < ee)
                overlaps.add(new int[]{ss, ee});
        }

        booked.add(new int[]{start, end});
        return true;
    }

}
```
time complexity:O(n^2)。假设有n个event，每个event都不会造成triple booking，每进行一次book花费O(i)(i<=n)，则n个event花费n*o(i)，故复杂度为O(n^2)


[title]: https://leetcode.com/problems/my-calendar-ii/description/