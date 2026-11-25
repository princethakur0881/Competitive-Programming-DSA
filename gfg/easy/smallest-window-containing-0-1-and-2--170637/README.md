# Smallest Window With 0, 1 and 2

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a string  **s**  consisting only of the characters ' **0'**, ' **1'**  and ' **2'**, determine the length of the smallest substring that contains all three characters at least once.

If no such substring exists, return  **-1**.

 **Examples :** 

```
Input: s = "10212"
Output: 3
Explanation: The substring "102" is the shortest substring that contains all three characters '0', '1', and '2', so the answer is 3.
```

```
Input: s = "12121"
Output: -1
Explanation: The character '0' is not present in the string, so no substring can contain all three characters '0', '1', and '2'. Hence, the answer is -1.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-25T07:06:52.958Z  

```java
class Solution {
    public int smallestSubstring(String s) {
       
       int zero=-1;
       int one=-1;
       int two=-1;
       int res,e,p;
       int len=(int)1e9;

       for(int i=0;i<s.length();i++)
       {
           if(s.charAt(i)=='0')
              zero=i;
           else if(s.charAt(i)=='1')
              one=i;
           else
              two=i;

           if(zero!=-1 && one!=-1 && two!=-1)
           {
               e=Math.max(zero,Math.max(one,two));
               p=Math.min(zero,Math.min(one,two));
               len=Math.min(len,e-p+1);
           }
       }
       res=(len>=1e9)?-1:len;
       return res;
        
    }
};

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/smallest-window-containing-0-1-and-2--170637/1)