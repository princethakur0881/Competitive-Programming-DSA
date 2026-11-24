# Two Pairs with Same Sum

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]**  of positive integers, find four indices  **a**,  **b**,  **c**, and  **d**  such that arr[a] + arr[b] = arr[c] + arr[d], where a, b, c, d are all distinct indices.

- If multiple such quadruplets exist, return the one that is lexicographically smallest when the indices are considered in the order a, b, c, d.
- If no such quadruplet exists, return {-1, -1, -1, -1}. 
- Ensure a < b and c < d, and the pair (a, b) is lexicographically smaller than the pair (c, d).

 **Examples:** 

```
Input: arr[] = [3, 4, 7, 1, 2, 9, 8]
Output: [0, 2, 3, 5]
Explanation: arr[0] + arr[2] = 3 + 7 = 10, arr[3] + arr[5] = 1 + 9 = 10. 
This is the lexicographically smallest such quadruplet of indices.
```

```
Input: arr[] = [1, 2, 3, 3]
Output: [-1, -1, -1, -1]
Explanation: No two distinct pairs of indices produce the same sum.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-24T07:18:52.298Z  

```java
class Solution {
    public ArrayList<Integer> findPairs(int[] arr) {
      HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
             for (int i = 0; i<arr.length; i++) {
                 for (int j = i + 1; j<arr.length; j++) {

                     int sum = arr[i]+arr[j];
                     map.putIfAbsent(sum, new ArrayList<>());
                     map.get(sum).add(new int [] {i, j});
                 }
             }

             for (int i = 0; i<arr.length; i++) {
                 for (int j = i + 1; j<arr.length; j++) {

                     int sum = arr[i]+arr[j];

                     if (map.containsKey(sum)) {

                         for (int[] pair : map.get(sum)) {
                             int a = pair[0];
                             int b = pair [1];

                             if (a != i && a != j &&
                             b != i && b != j &&
                             (i < a)) {

                                 return new ArrayList<>(Arrays.asList(i, j, a, b));
                             }

                         }
                     }
                 }
             }

             return new ArrayList<>(Arrays.asList(-1, -1, -1, -1));
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/satisfy-the-equation5847/1)