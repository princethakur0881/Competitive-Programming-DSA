# Minimum Changes to Make K Semi-palindromes

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given a string `s` and an integer `k`, partition `s` into `k`  **substrings**  such that the letter changes needed to make each substring a  **semi-palindrome**  are minimized.

Return the  ***minimum**  number of letter changes *required*.*

A  **semi-palindrome**  is a special type of string that can be divided into  **palindromes**  based on a repeating pattern. To check if a string is a semi-palindrome:​

- Choose a positive divisor d of the string's length. d can range from 1 up to, but not including, the string's length. For a string of length 1, it does not have a valid divisor as per this definition, since the only divisor is its length, which is not allowed.
- For a given divisor d, divide the string into groups where each group contains characters from the string that follow a repeating pattern of length d. Specifically, the first group consists of characters at positions 1, 1 + d, 1 + 2d, and so on; the second group includes characters at positions 2, 2 + d, 2 + 2d, etc.
- The string is considered a semi-palindrome if each of these groups forms a palindrome.

Consider the string `"abcabc"`:

- The length of "abcabc" is 6. Valid divisors are 1, 2, and 3.
- For d = 1: The entire string "abcabc" forms one group. Not a palindrome.
- For d = 2: Group 1 (positions 1, 3, 5): "acb" Group 2 (positions 2, 4, 6): "bac" Neither group forms a palindrome.
- For d = 3: Group 1 (positions 1, 4): "aa" Group 2 (positions 2, 5): "bb" Group 3 (positions 3, 6): "cc" All groups form palindromes. Therefore, "abcabc" is a semi-palindrome.

 

Original
Java
 **Example 1:** 

 **Input:**  s = "abcac", k = 2

 **Output:**  1

 **Explanation:**  Divide `s` into `"ab"` and `"cac"`. `"cac"` is already semi-palindrome. Change `"ab"` to `"aa"`, it becomes semi-palindrome with `d = 1`.

 **Example 2:** 

 **Input:**  s = "abcdef", k = 2

 **Output:**  2

 **Explanation:**  Divide `s` into substrings `"abc"` and `"def"`. Each needs one change to become semi-palindrome.

 **Example 3:** 

 **Input:**  s = "aabbaa", k = 3

 **Output:**  0

 **Explanation:**  Divide `s` into substrings `"aa"`, `"bb"` and `"aa"`. All are already semi-palindromes.

 

 **Constraints:** 

- 2 <= s.length <= 200
- 1 <= k <= s.length / 2
- s contains only lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 148 ms (beats 76.67%)  
**Memory:** 47.4 MB (beats 10.00%)  
**Submitted:** 2026-11-17T14:56:39.129Z  

```java
class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length(), inf = Integer.MAX_VALUE / 2;
        int[][] cost = new int[n + 1][n + 1];  // cost[i][j]: changes to make s[i:j] a semi-palindrome
        for (int[] row : cost)
            Arrays.fill(row, inf);
        for (int d = 1; 2 * d <= n; d++)
            for (int length = 2 * d; length <= n; length += d)  // every length that d divides, with d < length
                for (int i = 0, j = length; j <= n; i++, j++)
                    cost[i][j] = Math.min(cost[i][j], peel(s, i, j, d));

        int[] best = new int[n + 1];  // best[j]: the fewest changes for s[:j] cut into the pieces placed so far
        Arrays.fill(best, inf);
        best[0] = 0;
        for (int pieces = 1; pieces < k; pieces++) {  // every piece but the last
            int[] next = new int[n + 1];
            Arrays.fill(next, inf);
            for (int j = 2 * pieces; j <= n - 2 * (k - pieces); j++)  // 2 letters for each piece, placed or still to come
                next[j] = extend(best, cost, j);
            best = next;
        }
        return extend(best, cost, n);  // the last piece ends at n
    }

    private int peel(String s, int i, int j, int d) {  // s[i:j] in blocks of d: the outer pair of blocks, then the inside
        int changes = 0;
        for (; j - i > d; i += d, j -= d)
            for (int t = 0; t < d; t++)
                if (s.charAt(i + t) != s.charAt(j - d + t))
                    changes++;
        return changes;
    }
     private int extend(int[] best, int[][] cost, int j) {  // the newest piece s[i:j] starts at an old cut i and gets at least 2 letters
        return IntStream.rangeClosed(0, j - 2).map(i -> best[i] + cost[i][j]).min().getAsInt();
    }

}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-changes-to-make-k-semi-palindromes/)