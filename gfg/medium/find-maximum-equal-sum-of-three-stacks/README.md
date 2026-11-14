# Max Equal Sum in 3 Stacks

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given three stacks  **s1**,  **s2**, and  **s3**, represented by arrays where the first element of each array represents the top of the corresponding stack.

Find the maximum possible equal sum(sum of all elements) of all three stacks by removing zero or more elements from the top of each stack.

If it is not possible to make the sum of all three stacks equal, return  **0**.

 **Examples:** 

```
Input: s1 = [3, 2, 1, 1, 1], s2 = [4, 3, 2], s3 = [2, 5, 4, 1]
Output: 5
Explanation: Remove 3 from s1, 4 from s2, and 2, 5 from s3. The remaining sums of all three stacks are equal to 5.

```

```
Input: s1 = [4,7], s2 = [10], s3 = [1,2,3]
Output: 0
Explanation: It is not possible to make the sums of all three stacks equal by removing elements from their tops.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-14T15:39:04.273Z  

```java
class Solution {
    
             public boolean solve(int sum[] ,  int target){
                   int l = 0 ;
                   int h = sum.length-1;

                   while(l <= h){
                       int mid = (l + h)/2;

                       if(sum[mid] == target)
                       return true;

                       else if(sum[mid] > target){
                           l = mid+1;
                       }
                       else h = mid-1;
                   }

                   return false;
               }
               public int maxEqualSum(ArrayList<Integer> s1, ArrayList<Integer> s2,
                                      ArrayList<Integer> s3) {
                   // code here
                   int sum1[] = new int[s1.size()];
                   int sum2[] =  new int[s2.size()];
                   int target = 0;
                   int max = 0 ;



                   for(int i = s1.size()-1 ; i>=0 ; i--){
                       if(i == s1.size()-1){
                            sum1[i] = s1.get(i);
                            continue;
                       }
                        sum1[i] = s1.get(i) + sum1[i+1];
                   }


                    for(int i = s2.size()-1 ; i>=0 ; i--){
                       if(i == s2.size()-1){
                            sum2[i] = s2.get(i);
                            continue;
                       }
                        sum2[i] = s2.get(i) + sum2[i+1];
                   }

                   for(int i = s3.size()-1 ; i>=0 ; i--){
                        target += s3.get(i);
                       if(solve(sum1,target) && solve(sum2,target))
                       max =Math.max(target,max);
                   }

                   return max;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/find-maximum-equal-sum-of-three-stacks/1)