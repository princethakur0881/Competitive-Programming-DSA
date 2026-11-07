# Java 1D Array (Part 2)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

For this problem, we have $2$ types of queries you can perform on a [List](https://docs.oracle.com/javase/7/docs/api/java/util/List.html):

1. Insert $y$ at index $x$:<br>
	<pre>Insert
    x y</pre>
    
2. Delete the element at index $x$:<br>
	<pre>Delete
    x</pre>

Given a list, $L$, of $N$ integers, perform $Q$ queries on the list. Once all queries are completed, print the modified list as a single line of space-separated integers. 

 

**Input Format**

The first line contains an integer, $N$ (the initial number of elements in $L$).	
The second line contains $N$ space-separated integers describing $L$.	
The third line contains an integer, $Q$ (the number of queries).	
The $2Q$ subsequent lines describe the queries, and each query is described over two lines:	

* If the first line of a query contains the String **Insert**, then the second line contains two space separated integers $x \ y$, and the value $y$ must be inserted into $L$ at index $x$. 	
* If the first line of a query contains the String **Delete**, then the second line contains index $x$, whose element must be deleted from $L$.           
         
**Constraints**  

- $ 1 \le N \le 4000 $<br>
- $ 1 \le Q \le 4000 $<br>
- Each element in  is a *32-bit integer*.

         

**Output Format**

Print the updated list $L$ as a single line of space-separated integers.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-07T16:02:44.013Z  

```java
import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
    // Return true if you can win the game; otherwise, return false.
        return playTurn(0, leap, game);
    }

    private static boolean legal(int pos, int mod, int[] game) {
        int idx = pos + mod;
        return (idx >= 0 && idx < game.length 
            && game[idx] == 0);
    }

    private static boolean help(int pos, int mod, int leap, int[] game) {
        return ((legal(pos, mod, game)) 
            && playTurn((pos + mod), leap, game));
    }

    private static boolean playTurn(int pos, int leap, int[] game) {
        if (pos >= (game.length - 1) || (pos + leap) >= game.length) { 
            return true; 
        } else { 
            game[pos] = -1; 
        }
        
        return (help(pos, leap, leap, game)) 
            || (help(pos, 1, leap, game)) 
            || (help(pos, -1, leap, game));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }
            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
            
        scan.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/java-list/problem)