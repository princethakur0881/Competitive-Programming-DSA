# Any Duplicate Within K Distance

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an array of integers,  **arr[]**  and an integer  **k**, check whether there exist two distinct indices i and j such that arr[i] is equal to arr[j] and the absolute difference between i and j is at most k.

 **Examples:** 

```
Input: arr[] = [1, 5, 4, 5, 1], k = 3
Output: true
Explanation: The element 5 occurs at indices 1 and 3. Their distance is |3 - 1| = 2, which is less than or equal to k.
```

```
Input: arr[] = [10, 2, 3, 4, 10, 5], k = 3
Output: false
Explanation: The element 10 occurs at indices 0 and 4. Their distance is |4 - 0| = 4, which is greater than k. Hence, no duplicate exists within the given distance.
```

```
Input: arr[] = [5, 1, 3, 2, 4], k = 3
Output: false
Explanation: All elements are distinct, so no duplicate exists.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-11T16:24:01.497Z  

```java
class Solution {
    public boolean checkWithinK(int[] arr, int k) {
      HashMap<Integer,Integer> map = new HashMap<>();

            for(int i = 0;i<arr.length;i++) {
                if(map.containsKey(arr[i])) {
                    if(i-map.get(arr[i]) <= k) {
                        return true;
                    }
                } 
                map.put(arr[i],i);
            }
            return false; 
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/kth-distance3757/1)