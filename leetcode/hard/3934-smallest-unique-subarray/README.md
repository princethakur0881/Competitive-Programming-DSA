# Smallest Unique Subarray

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an integer array `nums`.

Find the  **minimum** length of a subarray that is  **not**   **identical**  to any other  **subarray**  in `nums`.

Return an integer denoting the  **minimum possible length**  of such a  **subarray**.

Two  **subarrays**  are considered identical if they have the same length and the same elements in corresponding positions.

 

Original
Java
 **Example 1:** 

 **Input:**  nums = [3,3,3]

 **Output:**  3

 **Explanation:** 

- Subarrays of length 1: [3] → appears 3 times
- Subarrays of length 2: [3, 3] → appears 2 times
- Subarrays of length 3: [3, 3, 3] → appears once

The subarray `[3, 3, 3]` is unique, so the smallest unique subarray length is 3.

 **Example 2:** 

 **Input:**  nums = [2,1,2,3,3]

 **Output:**  1

 **Explanation:** 

Subarrays of length 1:

- [2] → appears 2 times
- [1] → appears once
- [3] → appears 2 times
The subarray `[1]` is unique, so the smallest unique subarray length is 1.

 **Example 3:** 

 **Input:**  nums = [1,1,2,2,1]

 **Output:**  2

 **Explanation:** 

Subarrays of length 1:

- [1] → appears 3 times
- [2] → appears 2 times

Subarrays of length 2:

- [1, 1] → appears once
- [1, 2] → appears once
- [2, 2] → appears once
- [2, 1] → appears once
There is at least one subarray of length 2 that is unique, so the smallest unique subarray length is 2.

 

 **Constraints:** 

- 1 <= nums.length <= 105
- 1 <= nums[i] <= 105

## Solution

**Language:** Java  
**Runtime:** 1387 ms (beats 14.29%)  
**Memory:** 147.8 MB (beats 76.79%)  
**Submitted:** 2026-11-25T07:10:25.797Z  

```java
class Solution {
       public int smallestUniqueSubarray(int[] nums) {
   int n = nums.length;
        List<int[]> names = new ArrayList<>();  // names.get(k)[i] is equal for equal windows of length 2^k starting at i
        names.add(nums);
        for (int half = 1; 2 * half <= n; half *= 2) {  // blocks of 2, 4, 8, ... while they fit
            long[] pairs = pairs(names.get(names.size() - 1), half);
            long[] ids = Arrays.stream(pairs).sorted().distinct().toArray();  // a pair's number: its place among the different pairs
            names.add(Arrays.stream(pairs).mapToInt(pair -> Arrays.binarySearch(ids, pair)).toArray());
        }

        int lo = 1, hi = n;  // the first length that works is in lo..hi
        while (lo < hi) {
            int mid = lo+(hi-lo) / 2;
            if (found(names, mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private boolean found(List<int[]> names, int length) {  // is some window of this length unique?
        int k = 31 - Integer.numberOfLeadingZeros(length);  // its first 2^k elements and its last 2^k cover it
        long[] pairs = pairs(names.get(k), length - (1 << k));
        Arrays.sort(pairs);  // equal pairs are neighbors now
        for (int i = 0; i < pairs.length; i++)
            if ((i == 0 || pairs[i - 1] != pairs[i]) && (i + 1 == pairs.length || pairs[i] != pairs[i + 1]))
                return true;
        return false;
    }

    private long[] pairs(int[] block, int shift) {  // every (block[i], block[i + shift]) as one long
        long[] pairs = new long[block.length - shift];
        for (int i = shift; i < block.length; i++)
            pairs[i - shift] = (long) block[i - shift] << 32 | block[i];
        return pairs;
    }
    
}
```

---

[View on LeetCode](https://leetcode.com/problems/smallest-unique-subarray/)