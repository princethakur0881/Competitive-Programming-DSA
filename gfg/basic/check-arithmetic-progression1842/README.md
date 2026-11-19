# Check Arithmetic Progression

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given an array  **arr[]**  of integers. Write a program to check whether an arithmetic progression can be formed using all the given elements. 

 **Examples:** 

```
Input: arr[] = [0, 12, 4, 8]
Output: true
Explanation: Rearrange given array as [0, 4, 8, 12] which forms an arithmetic progression.
```

```
Input: arr[] = [12, 40, 11, 20]
Output: false
Explanation: there is no rearrangment which can forms an arithmetic progression.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-19T14:55:25.860Z  

```java
class Solution {
    // Function to check if the given array forms an arithmetic progression
    public boolean checkIsAP(int[] arr) {
       Arrays.sort(arr);

               int initialdiff = 0;
               for(int i = 0; i<(arr.length-1);i++){
                   int diff = arr[i+1] - arr[i];
                       if(i == 0){
                           initialdiff = diff;
                       }
                   if(initialdiff != diff){
                       return false;
                   }
               }
               return true;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/check-arithmetic-progression1842/1)