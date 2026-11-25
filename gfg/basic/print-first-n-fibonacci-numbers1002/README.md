# First n Fibonacci using Recursion

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given a number  **n**, return an array containing the first n Fibonacci numbers.

- The first two Fibonacci numbers are 0 and 1. 
- Each subsequent Fibonacci number is obtained by adding the previous two numbers.

 **Examples:** 

```
Input: n = 5
Output: [0, 1, 1, 2, 3]
Explanation: The first 5 Fibonacci numbers are 0, 1, 1, 2, 3.

```

```
Input: n = 7
Output: [0, 1, 1, 2, 3, 5, 8]
Explanation: The first 7 Fibonacci numbers are 0, 1, 1, 2, 3, 5, 8.
```

```
Input: n = 2
Output: [0, 1]
Explanation: The first 2 Fibonacci numbers are 0 and 1.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-25T07:03:50.354Z  

```java
class Solution {
    public ArrayList<Integer> fibonacciNumbers(int n) {
      if(n==1){
               ArrayList<Integer> result=new ArrayList<>();
              result.add(0);
              return result;
          }if(n==2){
               ArrayList<Integer> result=new ArrayList<>();
              result.add(0);
              result.add(1);
              return result;
          }
          ArrayList<Integer>result=fibonacciNumbers(n-1);

          int size= result.size();
          int next=result.get(size-1)+result.get(size-2);
          result.add(next);
          return result;
        
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/print-first-n-fibonacci-numbers1002/1)