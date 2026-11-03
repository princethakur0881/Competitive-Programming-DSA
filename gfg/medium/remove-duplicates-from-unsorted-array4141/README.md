# remove-duplicates-from-unsorted-array4141

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

_Description not available._

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-03T14:11:19.786Z  

```java
class Solution {
    static ArrayList<Integer> removeDuplicate(int arr[]) {
     LinkedHashSet<Integer> nums = new LinkedHashSet<>();

             for(int k : arr){
                 nums.add(k);
             }

             ArrayList<Integer> list = new ArrayList<>(nums);
             return list;
        
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/remove-duplicates-from-unsorted-array4141/1)