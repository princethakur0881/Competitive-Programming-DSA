# Minimum Operations to Make Elements Within K Subarrays Equal

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an integer array `nums` and two integers, `x` and `k`. You can perform the following operation any number of times (**including zero**):

- Increase or decrease any element of nums by 1.

Return the  **minimum**  number of operations needed to have  **at least**  `k`  *non-overlapping subarrays*  of size  **exactly**  `x` in `nums`, where all elements within each subarray are equal.

 

 **Example 1:** 

 **Input:**  nums = [5,-2,1,3,7,3,6,4,-1], x = 3, k = 2

 **Output:**  8

 **Explanation:** 

- Use 3 operations to add 3 to nums[1] and use 2 operations to subtract 2 from nums[3]. The resulting array is [5, 1, 1, 1, 7, 3, 6, 4, -1].
- Use 1 operation to add 1 to nums[5] and use 2 operations to subtract 2 from nums[6]. The resulting array is [5, 1, 1, 1, 7, 4, 4, 4, -1].
- Now, all elements within each subarray [1, 1, 1] (from indices 1 to 3) and [4, 4, 4] (from indices 5 to 7) are equal. Since 8 total operations were used, 8 is the output.

 **Example 2:** 

 **Input:**  nums = [9,-2,-2,-2,1,5], x = 2, k = 2

 **Output:**  3

 **Explanation:** 

- Use 3 operations to subtract 3 from nums[4]. The resulting array is [9, -2, -2, -2, -2, 5].
- Now, all elements within each subarray [-2, -2] (from indices 1 to 2) and [-2, -2] (from indices 3 to 4) are equal. Since 3 operations were used, 3 is the output.

 

 **Constraints:** 

- 2 <= nums.length <= 105
- -106 <= nums[i] <= 106
- 2 <= x <= nums.length
- 1 <= k <= 15
- 2 <= k * x <= nums.length

## Solution

**Language:** Java  
**Runtime:** 486 ms (beats 84.21%)  
**Memory:** 149.9 MB (beats 65.79%)  
**Submitted:** 2026-11-04T13:32:43.256Z  

```java
class Window {
    private final int[] nums;
    private final int x, odd;
    private final Comparator<Integer> order;  // by value, then by index
    private final TreeSet<Integer> s;         // indices of the window
    private int mid;                          // index of the (h+1)-th smallest: everything before it is the low half
    private long low, total;

    Window(int[] nums, int x) {
        this.nums = nums;
        this.x = x;
        odd = x & 1;
        order = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : Integer.compare(a, b);
        s = new TreeSet<>(order);
        for (int i = 0; i < x; i++) {
            s.add(i);
            total += nums[i];
        }
        Iterator<Integer> it = s.iterator();
        for (int i = 0; i < x / 2; i++)
            low += nums[it.next()];
        mid = it.next();
    }

    long cost() {  // larger half minus smaller half
        return total - 2 * low - (long) odd * nums[mid];
    }

    long slide(int in) {
        int out = in - x;
        s.add(in);
        if (order.compare(in, mid) < 0) {  // in joins the low half and pushes its largest up
            mid = s.lower(mid);
            low += nums[in] - nums[mid];
        }
        if (order.compare(out, mid) < 0) {  // out leaves the low half: mid moves down into it
            low += nums[mid] - nums[out];
            mid = s.higher(mid);
        } else if (out == mid) {
            mid = s.higher(mid);
        }
        s.remove(out);
        total += nums[in] - nums[out];
        return cost();
    }
}

class Solution {
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        Window win = new Window(nums, x);
        long[] cost = new long[n - x + 1];
        cost[0] = win.cost();
        for (int i = x; i < n; i++)
            cost[i - x + 1] = win.slide(i);

        long[] best = new long[n + 1];  // best[i]: min ops for the windows placed so far inside nums[0..i)
        for (int j = 0; j < k; j++) {
            long[] layer = new long[n + 1];
            Arrays.fill(layer, 0, x, Long.MAX_VALUE / 2);
            for (int i = x; i <= n; i++)
                layer[i] = Math.min(layer[i - 1], best[i - x] + cost[i - x]);
            best = layer;
        }
        return best[n];
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-operations-to-make-elements-within-k-subarrays-equal/)