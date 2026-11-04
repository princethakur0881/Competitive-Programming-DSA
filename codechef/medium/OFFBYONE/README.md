# OFFBYONE

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Off by One

You are given a binary string $S$ of length $N-1$.

Count the permutations $P$ of $\{1, 2, \ldots, N\}$ such that, for every $1 \leq i \lt N$,

- if $S_i = 1$, then $|P_i - P_{i+1}| = 1$
- if $S_i = 0$, then $|P_i - P_{i+1}| \neq 1$.

A permutation of $\{1, 2, \ldots, N\}$ is an array of length $N$ that contains every integer from $1$ to $N$.

Since the answer can be large, output it modulo $998244353$.

### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- Each test case consists of two lines of input. The first line of each test case contains a single integer $N$ — the length of the permutation. The second line contains the binary string $S$ of length $N-1$.
### Output Format

For each test case, output on a new line the number of valid permutations, modulo $998244353$.

### Constraints
- $1 \leq T \leq 10^5$
- $2 \leq N \leq 4000$
- $S$ consists only of the characters 0 and 1.
- The sum of $N^2$ over all test cases does not exceed $4000^2$.
### Sample 1:
Input
Output

```
4
4
000
5
0101
6
01001
16
010001001000010

```

```
2
14
42
228019520

```

### Explanation:

 **Test case 1:**  The valid permutations are $[2, 4, 1, 3]$ and $[3, 1, 4, 2]$.

 **Test case 4:**  There are $2224508226$ valid permutations, which is $228019520$ modulo $998244353$.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-04T15:02:03.740Z  

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here

	}
}

```

---

[View on CodeChef](https://www.codechef.com/problems/OFFBYONE)