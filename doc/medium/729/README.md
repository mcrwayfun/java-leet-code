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
如果有两个区间，分别是[s1,e1)和[s2,e2)，下列四种情况表示区间有交集：
![](https://i.imgur.com/j2DVL56.png)
判断是否有交集只用比较`max(s1,s2) < min(e1,e2)`，若为真，则表示有交集

```java
public class MyCalendar {

    private List<int[]> calerdar;

    public MyCalendar() {
        calerdar = new ArrayList<>();
    }

    public boolean book(int start, int end) {

        for (int[] val : calerdar)
            if (Math.max(val[0], start) < Math.min(val[1], end))
                return false;

        calerdar.add(new int[]{start, end});
        return true;
    }
}
```
time complexity:O(n^2)。假设有n个event，每个event都不会造成double booking，每进行一次book花费O(i)(i<=n)，则n个event花费n*o(i)，故复杂度为O(n^2)

## 思路2
TreeMap本身具有排序的性质，通过TreeMap的`floorEntry`和`ceilingEntry`方法，
- floorEntry：largest entry whose key <= given key
- ceilingEntry：smallest entry whose key > given key

区间有交集可以总结为以下两大类：

![](https://i.imgur.com/7Ei7X7p.png)


```java
public class MyCalendar {

    TreeMap<Integer,Integer> calendar;

    public MyCalendar2() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {

        Map.Entry<Integer, Integer> floorEntry = calendar.floorEntry(start);
        Map.Entry<Integer, Integer> ceilingEntry = calendar.ceilingEntry(start);

        if(floorEntry != null && floorEntry.getValue() > start)
            return false;

        if(ceilingEntry != null && ceilingEntry.getKey() < end)
            return false;

        calendar.put(start,end);
        return true;
    }
}
```
time complexity:O(nlogn)。共有n个event，每次book操作花费O(logn)，故复杂度为O(nlogn)

## 思路3
查找不重复的可以利用搜索二叉树，能够满足左结点<根结点<右结点，结点结构如下：
结点包含了开始时间，结束时间和左右子结点
```java
 class Node {
        public Node(int start, int end) {
            l = start;
            r = end;
        }

        int l, r;
        Node left, right;
    }
```
1. 判断根结点是存在，若不存在则建立
2. 循环当前树，建立标识`leftTag`来表示该插入左结点还是右结点。若新区间的`end<=l`,表明该新区间应该插入左结点，往左递归，`leftTag=true`；若新区间的`start>=r`，则应该插入右结点，往右递归，`leftTag=false`；如果以上情况都不是，则有重叠，直接返回false；
3. `leftTag=true`则将区间[start,end)插入左结点，否则插入右结点

现在假设有三个区间，分别是[10,20),[25,35),[36,39),则执行过程如下图所示：

![](https://i.imgur.com/O61x5G1.png)

```java

public class MyCalendar {

    //节点有起始结束时间和左右子节点
    class Node {

        public Node(int start, int end) {
            l = start;
            r = end;
        }

        int l, r;
        Node left, right;
    }

    Node root = null;

    public boolean book(int start, int end) {
        if (root == null) {
            root = new Node(start, end);
        } else {
            Node cur = root;
            //父节点
            Node pre = null;
            //记录该插入的节点是左子还是右子
            boolean leftTag = false;
            while (cur != null) {
                pre = cur;
                //应该在当前节点的左侧，往左子递归
                if (end <= cur.l) {
                    leftTag = true;
                    cur = cur.left;
                }
                //应该在当前节点的右侧，往右子递归
                else if (start >= cur.r) {
                    leftTag = false;
                    cur = cur.right;
                }
                // 有重叠，不应该插入，返回false
                else {
                    return false;
                }
            }
            //根据tag确定是父亲的左子还是右子
            if (leftTag) {
                pre.left = new Node(start, end);
            } else {
                pre.right = new Node(start, end);
            }
        }
        return true;

    }

}

```
time complexity:O(n^2)

[title]: https://leetcode.com/problems/my-calendar-i/description/