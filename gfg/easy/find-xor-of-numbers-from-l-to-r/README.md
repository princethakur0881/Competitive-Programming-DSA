# XOR of Number Range

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given two integers  **l**  and  **r**, find the bitwise XOR of all integers in the range  **[l, r]**  (both inclusive).

 **Examples:** 

```
Input: l = 4, r = 8 
Output: 8 
Explanation: The XOR of all integers from 4 to 8 is (4 xor 5 xor 6 xor 7 xor 8) = 8.
```

```
Input: l = 2, r = 4
Output: 5
Explanation: The XOR of all integers from 2 to 4 is (2 xor 3 xor 4) = 5.
```

```
Input: l = 5, r = 9
Output: 5
Explanation: The XOR of all integers from 5 to 9 is (5 xor 6 xor 7 xor 8 xor 9) = 5.

```

**Constraints:
**

1 ≤ l ≤ r ≤ 109

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-18T14:19:46.151Z  

```java
class Solution {
    private int xorTillN(int n) {
           return switch (n & 3) {
               case 0 -> n;
               case 1 -> 1;
               case 2 -> n + 1;
               default -> 0;
           };
       }
    public int findXOR(int l, int r) {
        return xorTillN(r) ^ xorTillN(l-1);
        
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/find-xor-of-numbers-from-l-to-r/1)