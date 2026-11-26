# Range Vowel Count Queries

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string  **s**  and a 2D array  **queries[][]**, where each query consists of two integers  **l**  and  **r**, find the number of vowels in the substring  **s[l....r]**  for each query. The substring includes both indices l and r.

Return an array containing the answers to all queries in the order they are given.

 **Examples:** 

```
Input: s = "geeksforgeeks", queries[][] = [[1, 3], [2, 4], [1, 9]]
Output: [2, 1, 4]
Explanation:
Query 1: "eek" has 2 vowels (e, e).
Query 2: "eks" has 1 vowel (e).
Query 3: "eeksforge" has 4 vowels (e, e, o, e).
```

```
Input: s = "helloworld", queries[][] = [[0, 4], [5, 9], [0, 9]]
Output: [2, 1, 3]
Explanation:
Query 1: "hello" has 2 vowels (e, o).
Query 2: "world" has 1 vowel (o).
Query 3: "helloworld" has 3 vowels (e, o, o).
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-26T14:00:56.097Z  

```java
class Solution {
    public ArrayList<Integer> countVowels(String s, int[][] queries) {
     
         if(s.trim().isEmpty() || queries.length==0){
             return new ArrayList<>();
         }

         ArrayList<Integer> list=new ArrayList<>();

         int[] prefix=new int[s.length()+1];

         for(int i=0;i<s.length();i++){
             prefix[i+1]=prefix[i]+(isVowel(s.charAt(i))?1:0);
         }

      

         for(int[] query:queries){
             int left=query[0];
             int right=query[1];

             int vowelCount=prefix[right+1]-prefix[left];
        

             list.add(vowelCount);
         }

        
         return list;
     }

     public static boolean isVowel(char c){
         return (c=='a'||c=='e'||c=='i'||c=='o'||c=='u');
     }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/range-vowel-count-queries-static/1)