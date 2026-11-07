# Java Arraylist

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Let's play a game on an array! You're standing at index $0$ of an $n$-element array named $game$. From some index $i$ (where $0 \le i \lt n$), you can perform one of the following moves:

* *Move Backward:* If cell $i - 1$ exists *and* contains a $0$, you can walk back to cell $i - 1$.
* *Move Forward:* 
	- If cell $i + 1$ contains a zero, you can walk to cell $i + 1$.
    - If cell $i + leap$ contains a zero, you can jump to cell $i + leap$.
    - If you're standing in cell $n - 1$ or the value of $i + leap \ge n$, you can walk or jump off the end of the array and win the game.

In other words, you can move from index $i$ to index $i+1$, $i-1$, or $i + leap$ as long as the destination index is a cell containing a $0$. If the destination index is greater than $n-1$, you win the game.

**Function Description**   

Complete the *canWin* function in the editor below.   

*canWin* has the following parameters:   

- *int leap:* the size of the leap   
- *int game[n]:* the array to traverse   

**Returns**   

- *boolean:* true if the game can be won, otherwise false   

**Input Format**

The first line contains an integer, $q$, denoting the number of queries (i.e., function calls). 	
The $2 \cdot q$ subsequent lines describe each query over two lines:

1. The first line contains two space-separated integers describing the respective values of $n$ and $leap$.
2. The second line contains $n$ space-separated binary integers (i.e., zeroes and ones) describing the respective values of $game_0, game_1, \ldots, game_{n-1}$.

**Constraints**

* $1 \le q \le 5000$
* $2 \le n \le 100$
* $0 \le leap \le 100$
* It is guaranteed that the value of $game[0]$ is always $0$.

**Output Format**

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-07T16:01:23.192Z  

```java
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
 Scanner obj=new Scanner(System.in);
    int n=obj.nextInt();
    ArrayList<ArrayList<Integer>> Line=new ArrayList<>();
    for(int i=0;i<n;i++)
    {
        int d=obj.nextInt();
        ArrayList<Integer> temp=new ArrayList<>();
        for(int j=0;j<d;j++)
        {
            temp.add(obj.nextInt());
        }
        Line.add(temp);
    }

    int q=obj.nextInt();
    ArrayList<ArrayList<Integer>> query=new ArrayList<>();
    for(int i=0;i<q;i++)
    {
        ArrayList<Integer> data=new ArrayList<>();
        for(int j=0;j<2;j++)
        {
            data.add(obj.nextInt());
        }
        query.add(data);
    }

    for(int i=0;i<query.size();i++)
    {
        int x=query.get(i).get(0);
        int y=query.get(i).get(1);
        if(y<=Line.get(x-1).size())
        {
            System.out.println(Line.get(x-1).get(y-1));
        }
        else
        {
            System.out.println("ERROR!");
        }
    }
    }
}
    

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/java-1d-array/problem)