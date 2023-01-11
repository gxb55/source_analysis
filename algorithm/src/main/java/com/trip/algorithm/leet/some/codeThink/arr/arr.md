# 数组
## 二分搜索

* 注意left和right的定义以及之后的运行，如果定义的是【left，right】即左闭右闭，当在计算mid的时候就分别+1，或者-1,因为边界值都已经计算过了；
* 如果left 和right的定义为[left,right) 即左闭右开，当计算mid的时候如果mid<val
  right=mid;即根据定义不会计算到right的值，因为是开区间，而且开区间导致while(left<right) 不能等于，因为right没有意义；
* [力扣69](https://leetcode.cn/problems/sqrtx/)

~~~ java
        // 左闭右闭
        long left = 0;
        long right = x;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long val = mid * mid;
            if (val > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        // 左闭右开
        long left = 0;
        long right = x;
        while (left <  right) {
            long mid = left + (right - left) / 2;
            long val = mid * mid;
            if (val > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
~~~
## 快慢指针
* 定义快指针，慢指针，快指针指的是后面的值，慢指针指的是实际的值，中间间隔的是无效的值，或者说是不要的值；
* 快指针指的是数组下标，慢指针指的是有效的值；
* [力扣283](https://leetcode.cn/problems/move-zeroes/)

## 滑动窗口
