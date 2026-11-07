# Java 1D Array (Part 2)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

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
**Submitted:** 2026-11-07T16:02:29.563Z  

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

[View on HackerRank](https://www.hackerrank.com/challenges/java-1d-array/problem)