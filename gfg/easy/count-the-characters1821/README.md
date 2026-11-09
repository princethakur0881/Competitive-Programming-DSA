# Count Group Occurrences

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a string  **s**  and an integer  **k**, count the number of distinct characters that appear in exactly  **k groups**  in the string.

A group is defined as one or more consecutive occurrences of the same character. For example, in the string "aaabbcca", the groups are "aaa", "bb", "cc" and "a".

 **Examples:** 

```
Input: s = "abc", k = 1
Output: 3
Explanation: The characters 'a', 'b' and 'c' each appear in exactly one group.
```

```
Input: s = "geeksforgeeks", k = 2
Output: 4
Explanation: The characters 'g', 'e', 'k' and 's' each appear in exactly two groups.
```

```
Input: s = "aaaaa", k = 2
Output: 0
Explanation: The character 'a' appears in only one group, so no character appears in exactly two groups.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-09T14:29:56.036Z  

```java
class Solution {
    int getCount(String s, int k) {
       HashMap<Character, Integer> map = new HashMap<>();

             int i = 0, n = s.length();

             while (i < n) {
                 char ch = s.charAt(i);
                 map.put(ch, map.getOrDefault(ch, 0) + 1);

                 int j = i + 1;
                 while (j < n && s.charAt(j) == ch) {
                     j++;
                 }
                 i = j;
             }

             int count = 0;
             for (int freq : map.values()) {
                 if (freq == k) count++;
             }

             return count;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/count-the-characters1821/1)