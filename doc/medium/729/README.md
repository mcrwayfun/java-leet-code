# [My Calendar I][title]

## Description

Implement a MyCalendar class to store your events. A new event can be added if adding the event will not cause a double booking.

Your class will have the method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.

A double booking happens when two events have some non-empty intersection (ie., there is some time that is common to both events.)

For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.

Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)

**Note**
- The number of calls to MyCalendar.book per test case will be at most 1000.
- In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].

**Example 1:**

```
MyCalendar();
MyCalendar.book(10, 20); // returns true
MyCalendar.book(15, 25); // returns false
MyCalendar.book(20, 30); // returns true
Explanation: 
The first event can be booked.  The second can't because time 15 is already booked by another event.
The third event can be booked, as the first event takes every time less than 20, but not including 20.
```

**Tags:** Tree

## 解读题意
这道题的意思是检查区间是否重叠

## 思路1 
如果有两个区间，分别是[s1,s2)和[e1,e2)。当`s2<=e1`或者`s1>=e2`，则这两个区间不会重叠。反之，当`s2>e1`并且`s1<e2`，则这两个区间重叠，利用这个思想来解决问题。

```java
public class MyCalendar {

    List<int[]> calendar;

    public MyCalendar() {
        calendar = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for(int[] val:calendar){
            if(val[0] < end && val[1] > start)
                return false;
        }
        calendar.add(new int[]{start,end});
        return true;
    }
}
```

## 思路2
与思路1一致，但是可以通过定义两个类变量而不用创建数组。

```java
public class MyCalendar {

    TreeMap tm;

    public MyCalendar() {
        tm = new TreeMap<Integer, Integer>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> entry = tm.lowerEntry(end);
        if (entry != null && entry.getValue() > start) return false;
        tm.put(start, end);
        return true;
    }
}
```

[title]: https://leetcode.com/problems/my-calendar-i/description/