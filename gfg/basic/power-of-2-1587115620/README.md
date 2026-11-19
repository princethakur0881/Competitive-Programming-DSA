# Power of 2

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given a non-negative integer  **n**, return true if it is a power of  **2**. Otherwise, return false.  

**Examples:
**

```
Input: n = 8
Output: true
Explanation: 8 is equal to 2 raised to 3 (23 = 8).
```

```
Input: n = 98
Output: false
Explanation: 98 cannot be obtained by any power of 2.
```

```
Input: n = 1
Output: true
Explanation: 1 is equal to 2 raised to 0 (20 = 1).
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-19T14:53:41.425Z  

```java
class Solution {
    public boolean isPowerofTwo(int n) {
      int res = 0;
          String s1 = "";
          while(n!=0) {
              res = n%2;
              n/=2;
              s1+= res;
          }
          int c =0;
          for(int i =0;i < s1.length();i++) {
              if(s1.charAt(i) == '1')
                 c++;
          }
             if(c==1)
                  return true;
             else
                 return false;
        
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/power-of-2-1587115620/1)