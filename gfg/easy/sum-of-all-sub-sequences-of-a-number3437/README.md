# Sum of All Digit Subsequences

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a string **s**  which consists of digits, find sum of all digits across all non-empty subsequences of s.

 **Note:**  Since the answer can be very large, return it modulo 10^9 + 7.

 **Examples:** 

```
Input: s = "123" 
Output: 24
Explanation: The non-empty subsequences are: [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]. The sum of all digits in these subsequences is: 1 + 2 + 3 + (1 + 2) + (1 + 3) + (2 + 3) + (1 + 2 + 3) = 24.

```

```
Input: s = "405"
Output: 36
Explanation: The non-empty subsequences are: [4], [0], [5], [4, 0], [4, 5], [0, 5], [4, 0, 5]. The sum of all digits in these subsequences is 36.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-15T14:07:51.949Z  

```java
class Solution {
    public int subsequenceSum(String s) {
          final int MOD = 1000000007;
        long ds = 0;
        int n = s.length();
        for (char ch : s.toCharArray())
            ds = (ds + ch - '0') % MOD;
        long df = 1;
        for (int i = 1; i < n; i++)
            df = (df * 2) % MOD;
        return (int)((ds * df) % MOD);
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/sum-of-all-sub-sequences-of-a-number3437/1)