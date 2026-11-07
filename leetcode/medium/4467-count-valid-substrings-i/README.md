# Q1. Count Valid Substrings I

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given a string `s` consisting only of the characters `'a'`, `'b'`, and `'c'`.

A string is called  **valid**  if it does not contain `"abc"` as a  **substring**.

Return the number of  **valid substrings**  in `s`. Substrings with different starting or ending indices are counted separately.

A  **substring**  is a contiguous  **non-empty**  sequence of characters within a string.

 

 **Example 1:** 

 **Input:**  s = "abac"

 **Output:**  10

 **Explanation:** 

The following substrings don't contain `"abc"`​​​​​​​ as a substring:

- s[0..0] = "a"
- s[0..1] = "ab"
- s[0..2] = "aba"
- s[0..3] = "abac"​​​​​​​
- s[1..1] = "b"
- s[1..2] = "ba"
- s[1..3] = "bac"
- s[2..2] = "a"
- s[2..3] = "ac"
- s[3..3] = "c"

Thus, the answer is 10.

 **Example 2:** 

 **Input:**  s = "abc"

 **Output:**  5

 **Explanation:** 

The following substrings don't contain `"abc"`​​​​​​​ as a substring:

- s[0..0] = "a"
- s[0..1] = "ab"
- s[1..1] = "b"
- s[1..2] = "bc"
- s[2..2] = "c"​​​​​​​

Thus, the answer is 5.

 **Example 3:** 

 **Input:**  s = "ac"

 **Output:**  3

 **Explanation:** 

All substrings in `s` don't contain `"abc"` as a substring​​​​​​​. Thus, the answer is 3.

 

 **Constraints:** 

- 1 <= s.length <= 105​​​​​​​
- s only consists of 'a', 'b', and 'c' characters.

## Solution

**Language:** Java  
**Runtime:** 12 ms (beats 100.00%)  
**Memory:** 47.6 MB (beats 100.00%)  
**Submitted:** 2026-11-07T15:43:45.149Z  

```java
class Solution {
    public long countValidSubstrings(String s) {
         int n = s.length();
        // Use long to prevent integer overflow for larger string lengths
        long totalSubstrings = (long) n * (n + 1) / 2;
        long invalidSubstrings = 0;
        int lastAbcStart = -1;
        
        for (int i = 2; i < n; i++) {
            // Check if the last 3 characters form "abc"
            if (s.charAt(i - 2) == 'a' && s.charAt(i - 1) == 'b' && s.charAt(i) == 'c') {
                lastAbcStart = i - 2;
            }
            
            // If an "abc" has been found, add the number of valid starting positions
            if (lastAbcStart != -1) {
                invalidSubstrings += (lastAbcStart + 1);
            }
        }
        
        return totalSubstrings - invalidSubstrings;
    }
}
 
```

---

[View on LeetCode](https://leetcode.com/problems/count-valid-substrings-i/)