# Smallest Subarray Sum Greater Than x

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an integer  **x** and an array of integers,  **arr[]**. Find the length of the smallest subarray whose sum is strictly greater than  **x**.

If no such subarray exists, return  **0**.

 **Examples:** 

```
Input: x = 51, arr[] = [1, 4, 45, 6, 0, 19]
Output: 3
Explanation: The smallest subarray with a sum greater than 51 is [4, 45, 6], whose sum is 55 and length is 3.
```

```
Input: x = 100, arr[] = [1, 10, 5, 2, 7]
Output: 0
Explanation: No subarray has a sum greater than 100. Hence, the answer is 0.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-21T18:05:46.648Z  

```java
class Solution {
    public int smallestSubWithSum(int[] arr, int x) {
       int n = arr.length;
              int left = 0;
              int sum = 0;
              int minLen = Integer.MAX_VALUE;

              for (int right = 0; right < n; right++) {
                  sum += arr[right];

                  while (sum > x) {
                      minLen = Math.min(minLen, right - left + 1);
                      sum -= arr[left];
                      left++;
                  }
              }

              return minLen == Integer.MAX_VALUE ? 0 : minLen;
        
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x5651/1)