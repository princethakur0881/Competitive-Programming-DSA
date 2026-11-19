# Highest and Lowest Frequencies

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given an array, the task is to find the difference between the highest occurrence and lowest occurrence of any numbers in an array. If only one type of element is present in the array return 0

 **Examples:** 

```
Input: arr[] = [1, 2, 2]
Output: 1
Explanation:  Lowest occurring element (1) occurs once. Highest occurring element (2) occurs 2 times
```

```
Input: arr[] = [7, 8, 4, 5, 4, 1, 1, 7, 7, 2, 5]
Output: 2
Explanation : Lowest occurring element (2) occurs once. Highest occurring element (7) occurs 3 times
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-19T14:52:25.941Z  

```java
class Solution {
    public int findDiff(int[] arr) {
       HashMap<Integer , Integer> map = new HashMap<>();

              for(int i : arr){

                  map.put(i , map.getOrDefault(i , 0) + 1);
              }
              if(map.size() == 1) return 0;

              int minFreq = Integer.MAX_VALUE;
              int maxFreq = Integer.MIN_VALUE;

              for(int freq : map.values()){

                  minFreq = Math.min(minFreq , freq);
                  maxFreq = Math.max(maxFreq , freq);
              }
              return maxFreq - minFreq;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/difference-between-highest-and-lowest-occurrence4613/1)