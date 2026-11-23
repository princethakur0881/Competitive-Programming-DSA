# Character at Position in Infinite String

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string  **s**  and an integer  **pos**, an infinite string is constructed by repeatedly applying the following operation. In the i-th step, append i consecutive $ characters, followed by the reverse of the current string, to the current string.

Formally, if the current string is s, update it as:

- s = s + ('$' repeated i times) + reverse(s)

The initial string is the given s, and the process continues indefinitely.

Find and return the character at the pos(1-based indexing) in the resulting infinite string.

 **Examples:** 

```
Input: s = "12345", pos = 3
Output: 3
Explanation: In "12345...", the character at pos 3 is 3.

```

```
Input: s = "12345", pos = 10
Output: 2
Explanation: In "12345$54321...", the character at pos 10 is 2.

```

```
Input: s = "abc", pos = 7
Output: a
Explanation: In "abc$cba...", the character at pos 7 is a.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-23T16:52:06.946Z  

```java
class Solution {
    public char posInfinite(String s, int pos) {
      long len = s.length();
            long target = pos;
            long step = 0;

            // Find the expansion step where length >= pos
            while (len < target) {
                step++;
                len = 2 * len + step;
            }

            // Trace the position back to the original string
            while (target > s.length()) {

                long prevLen = (len - step) / 2;

                // Position is inside the '$' block
                if (target > prevLen && target <= prevLen + step) {
                    return '$';
                }

                // Position is inside the reversed string
                if (target > prevLen + step) {
                    target = len - target + 1;
                }

                len = prevLen;
                step--;
            }

            return s.charAt((int) target - 1);
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/the-infinite-string1049/1)