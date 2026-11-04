# TELEPHN

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Telephone

$N$ friends are sitting around a round table, playing a game of Telephone. Friend $i$ starts with the number $A_i$.
The friends are numbered $1$ to $N$ in clockwise order, so friend $i$ sits between friends $i-1$ and $i+1$; friend $1$ sits between friends $N$ and $2$.

Every second, all the friends call out their numbers at the same time. Each friend hears only the two friends sitting next to them, forgets their own number, and takes the  **larger**  of the two numbers they heard.

Formally, every second, $A_i$ is replaced by $\max(A_{i-1}, A_{i+1})$, where indices are taken cyclically.
This happens for all $1 \le i \le N$  **simultaneously**.

Find the  **minimum**  number of seconds after which all the friends hold the same number, or report that this never happens.

### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- Each test case consists of two lines of input. The first line of each test case contains a single integer $N$ — the number of friends. The second line contains $N$ space-separated integers $A_1, A_2, \ldots, A_N$ — the starting numbers of the friends.
### Output Format

For each test case, output on a new line the minimum number of seconds after which all the friends hold the same number, or $-1$ if this never happens.

### Constraints
- $1 \leq T \leq 10^5$
- $3 \leq N \leq 2 \cdot 10^5$
- $1 \leq A_i \leq 10^9$
- The sum of $N$ over all test cases does not exceed $2 \cdot 10^5$.
### Sample 1:
Input
Output

```
4
6
3 8 2 8 6 1
5
4 2 7 3 5
8
6 9 4 1 7 3 9 2
7
5 9 2 6 9 1 4

```

```
-1
4
3
4

```

### Explanation:

 **Test case 1:**  It can be verified that the numbers will never be all equal.

 **Test case 2:**  The numbers change as follows: $[4, 2, 7, 3, 5] \to [5, 7, 3, 7, 4] \to [7, 5, 7, 4, 7] \to [7, 7, 5, 7, 7] \to [7, 7, 7, 7, 7]$.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-04T14:47:44.680Z  

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int maxVal = 0;
            
            // Read array and find the maximum value
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (a[i] > maxVal) {
                    maxVal = a[i];
                }
            }
            
            // dist[i][0] = distance to closest max value with even steps
            // dist[i][1] = distance to closest max value with odd steps
            int[][] dist = new int[n][2];
            for (int i = 0; i < n; i++) {
                dist[i][0] = -1;
                dist[i][1] = -1;
            }
            
            // Queues for BFS
            int[] qNode = new int[2 * n + 5];
            int[] qParity = new int[2 * n + 5];
            int head = 0, tail = 0;
            
            // Multi-source BFS starting from all cells containing the max value
            for (int i = 0; i < n; i++) {
                if (a[i] == maxVal) {
                    dist[i][0] = 0; // 0 steps is even
                    qNode[tail] = i;
                    qParity[tail] = 0;
                    tail++;
                }
            }
            
            // Standard BFS traversal
            while (head < tail) {
                int curr = qNode[head];
                int p = qParity[head];
                head++;
                
                int nextP = 1 - p; // Flips 0 to 1, or 1 to 0
                
                // Left neighbor (cyclical wrapper)
                int left = (curr == 0) ? n - 1 : curr - 1;
                if (dist[left][nextP] == -1) {
                    dist[left][nextP] = dist[curr][p] + 1;
                    qNode[tail] = left;
                    qParity[tail] = nextP;
                    tail++;
                }
                
                // Right neighbor (cyclical wrapper)
                int right = (curr == n - 1) ? 0 : curr + 1;
                if (dist[right][nextP] == -1) {
                    dist[right][nextP] = dist[curr][p] + 1;
                    qNode[tail] = right;
                    qParity[tail] = nextP;
                    tail++;
                }
            }
            
            int maxOddSteps = 0;
            int maxEvenSteps = 0;
            boolean possibleOdd = true;
            boolean possibleEven = true;
            
            // Check max required steps for both even and odd targets
            for (int i = 0; i < n; i++) {
                if (dist[i][1] == -1) possibleOdd = false;
                else maxOddSteps = Math.max(maxOddSteps, dist[i][1]);
                
                if (dist[i][0] == -1) possibleEven = false;
                else maxEvenSteps = Math.max(maxEvenSteps, dist[i][0]);
            }
            
            int ansOdd = Integer.MAX_VALUE;
            if (possibleOdd) {
                // If max needed steps is even, we must round up to the next odd time
                ansOdd = (maxOddSteps % 2 == 1) ? maxOddSteps : maxOddSteps + 1;
            }
            
            int ansEven = Integer.MAX_VALUE;
            if (possibleEven) {
                // If max needed steps is odd, we must round up to the next even time
                ansEven = (maxEvenSteps % 2 == 0) ? maxEvenSteps : maxEvenSteps + 1;
            }
            
            int finalAns = Math.min(ansOdd, ansEven);
            
            if (finalAns == Integer.MAX_VALUE) {
                System.out.println("-1");
            } else {
                System.out.println(finalAns);
            }
        }
        
        sc.close();

	}
}

```

---

[View on CodeChef](https://www.codechef.com/problems/TELEPHN)