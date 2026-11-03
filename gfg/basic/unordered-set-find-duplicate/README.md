# Duplicates in Array

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given an integer array  **arr[]**, return a list containing all distinct elements that appear more than once in the array. The returned list must maintain the order in which these elements are encountered for the second time in the original array.

 **Note:**  Each duplicate element should appear exactly once in the result. If no duplicates exist return [-1].

 **Example:** 

```
Input: arr[]= [1, 1, 2, 2]
Output: [1, 2]
Explanation: Both 1 and 2 appear more than once. The second occurrence of 1 comes before the second occurrence of 2.
```

```
Input: arr[] = [2, 4, 1, 3, 4, 2, 2, 3]
Output: [4, 2, 3]
Explanation: The second occurrences of 4, 2 and 3 are encountered in that order.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-03T14:27:00.760Z  

```java
class Solution {
    public List<Integer> findDuplicates(int[] arr) {
     HashSet<Integer> seen = new HashSet<>();
               HashSet<Integer> duplicates = new HashSet<>();
               List<Integer> result = new ArrayList<>();

               // Step 1: Find all numbers that appear more than once
               for (int num : arr) {
                   if (!seen.add(num)) {
                       duplicates.add(num); // If it's already seen, it's a duplicate
                   }
               }

               // Step 2: Collect the duplicates in the order of their FIRST appearance
               HashSet<Integer> addedToResult = new HashSet<>();
               for (int num : arr) {
                   if (duplicates.contains(num) && !addedToResult.contains(num)) {
                       result.add(num);
                       addedToResult.add(num); // Ensure each duplicate is only added once
                   }
               }

               // Step 3: Handle the base case if no duplicates exist
               if (result.isEmpty()) {
                   result.add(-1);
               }

               return result;

    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/unordered-set-find-duplicate/1)