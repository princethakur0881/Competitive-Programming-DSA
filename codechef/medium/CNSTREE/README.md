# CNSTREE

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Consistentree (Updates)

You are given a tree with $N$ vertices. Each vertex $v$ has a value $A_v$, which is one of $-1$, $0$ and $1$.

The tree is called  **consistent**  if it is possible to assign the distinct labels $1, 2, \ldots, N$ to its vertices such that, for every vertex $v$:

- If $A_v = -1$, the label of $v$ is smaller than the label of every neighbor of $v$.
- If $A_v = 1$, the label of $v$ is larger than the label of every neighbor of $v$.
- If $A_v = 0$, the label of $v$ is larger than the label of at least one neighbor of $v$, and smaller than the label of at least one neighbor of $v$.

You are given $Q$ updates. Each update chooses a vertex $v$ whose current value is nonzero, and multiplies $A_v$ by $-1$. Updates are persistent.

After  **each**  update, determine whether the tree is consistent.

### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- Each test case consists of multiple lines of input. The first line of each test case contains two space-separated integers $N$ and $Q$ — the number of vertices of the tree and the number of updates. The second line contains $N$ space-separated integers $A_1, A_2, \ldots, A_N$ — the initial values of the vertices. The next $N-1$ lines describe the edges. Each of these lines contains two space-separated integers $u$ and $v$, denoting an edge between vertices $u$ and $v$. The next $Q$ lines describe the updates. Each of these lines contains a single integer $v$ — the vertex chosen by the update.
### Output Format

For each update, output on a new line `YES` if the tree is consistent after it, and `NO` otherwise.

Each letter of the output may be printed in either uppercase or lowercase.

### Constraints
- $1 \leq T \leq 10^5$
- $3 \leq N \leq 2 \cdot 10^5$
- $1 \leq Q \leq 2 \cdot 10^5$
- $A_i \in \{-1, 0, 1\}$.
- At least one vertex initially has a nonzero value.
- $1 \leq u, v \leq N$, and the given edges form a tree.
- Each updated vertex has a nonzero value at the time of the update.
- The sum of $N$ over all test cases does not exceed $2 \cdot 10^5$.
- The sum of $Q$ over all test cases does not exceed $2 \cdot 10^5$.
### Sample 1:
Input
Output

```
4
6 6
-1 -1 -1 1 0 1
5 6
2 4
3 1
5 2
3 5
3
1
3
4
2
6
6 6
1 0 -1 1 0 -1
2 6
5 1
2 5
5 4
2 3
1
4
6
3
1
4
5 6
0 0 -1 -1 1
4 2
2 5
5 1
1 3
4
5
3
4
5
3
7 6
1 0 1 -1 -1 0 -1
2 5
6 1
5 3
6 7
3 6
2 4
4
7
1
4
7
4

```

```
YES
NO
YES
NO
YES
YES
YES
NO
YES
YES
YES
NO
NO
NO
YES
NO
NO
YES
YES
NO
YES
NO
NO
YES

```

### Explanation:

 **Test case $1$:**  After the first update, $A = [-1, -1, 1, 1, 0, 1]$, and the labels $[1, 2, 4, 5, 3, 6]$ work.

After the second update, $A = [1, -1, 1, 1, 0, 1]$. Vertices $1$ and $3$ are adjacent and both must have larger labels than each other, which is impossible.

 **Test case $3$:**  After the first update, $A = [0, 0, -1, 1, 1]$. Vertices $4$ and $5$ must both have larger labels than vertex $2$, so vertex $2$ cannot be larger than any of its neighbors.

After the third update, $A = [0, 0, 1, 1, -1]$, and the labels $[2, 3, 4, 5, 1]$ work.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-04T15:06:10.263Z  

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	

	}
}

```

---

[View on CodeChef](https://www.codechef.com/problems/CNSTREE)