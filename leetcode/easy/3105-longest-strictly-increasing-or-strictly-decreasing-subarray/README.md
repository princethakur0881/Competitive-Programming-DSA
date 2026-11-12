# Longest Strictly Increasing or Strictly Decreasing Subarray

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given an array of integers `nums`. Return  *the length of the  **longest**  subarray of* `nums` *which is either  **strictly increasing**  or  **strictly decreasing***.

 

Original
Java
 **Example 1:** 

 **Input:** 
int[] nums = new int[]{1, 4, 3, 3, 2};

 **Output:**  2

 **Explanation:** 

The strictly increasing subarrays of `nums` are `[1]`, `[2]`, `[3]`, `[3]`, `[4]`, and `[1,4]`.

The strictly decreasing subarrays of `nums` are `[1]`, `[2]`, `[3]`, `[3]`, `[4]`, `[3,2]`, and `[4,3]`.

Hence, we return `2`.

 **Example 2:** 

 **Input:** 
int[] nums = new int[]{3, 3, 3, 3};

 **Output:**  1

 **Explanation:** 

The strictly increasing subarrays of `nums` are `[3]`, `[3]`, `[3]`, and `[3]`.

The strictly decreasing subarrays of `nums` are `[3]`, `[3]`, `[3]`, and `[3]`.

Hence, we return `1`.

 **Example 3:** 

 **Input:** 
int[] nums = new int[]{3, 2, 1};

 **Output:**  3

 **Explanation:** 

The strictly increasing subarrays of `nums` are `[3]`, `[2]`, and `[1]`.

The strictly decreasing subarrays of `nums` are `[3]`, `[2]`, `[1]`, `[3,2]`, `[2,1]`, and `[3,2,1]`.

Hence, we return `3`.

 

 **Constraints:** 

- 1 <= nums.length <= 50
- 1 <= nums[i] <= 50

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 98.38%)  
**Memory:** 43.3 MB (beats 99.68%)  
**Submitted:** 2026-11-12T16:18:51.557Z  

```java
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
         int best = 1, up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            up = nums[i - 1] < nums[i] ? up + 1 : 1;  // increasing streak ending at nums[i]
            down = nums[i - 1] > nums[i] ? down + 1 : 1;  // decreasing streak ending at nums[i]
            best = Math.max(best, Math.max(up, down));
        }
        return best;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/)