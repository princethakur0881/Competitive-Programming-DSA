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
**Submitted:** 2026-11-04T15:04:12.774Z  

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{

    private static final int MOD = 998244353;

    public static void main(String[] args)throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        // Precompute factorials up to N = 4000
        long[] fact = new long[4001];
        fact[0] = 1;
        for (int i = 1; i <= 4000; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            // dp[k][0] -> Ways to form configuration with k chains, where the current chain has length 1
            // dp[k][1] -> Ways to form configuration with k chains, where the current chain has length > 1
            long[][] dp = new long[n + 2][2];
            dp[1][0] = 1; // Start with 1 chain of length 1

            for (int i = 0; i < n - 1; i++) {
                char c = s.charAt(i);
                long[][] nextDp = new long[n + 2][2];

                for (int k = 1; k <= n; k++) {
                    long waysLen1 = dp[k][0];
                    long waysLenMore = dp[k][1];
                    if (waysLen1 == 0 && waysLenMore == 0) continue;

                    if (c == '1') {
                        // Force current chain to expand (it's guaranteed to be length > 1 now)
                        // Expanding a length 1 chain multiplies choices by 2 (can be increasing or decreasing)
                        nextDp[k][1] = (nextDp[k][1] + waysLen1 * 2 + waysLenMore) % MOD;
                    } else {
                        // Option 1: Force current chain to expand anyway (Inclusion-Exclusion weight -1)
                        long expandWays = (waysLen1 * (MOD - 2) + waysLenMore * (MOD - 1)) % MOD;
                        nextDp[k][1] = (nextDp[k][1] + expandWays) % MOD;

                        // Option 2: Finish current chain normally and start a new chain (weight +1)
                        long splitWays = (waysLen1 + waysLenMore) % MOD;
                        nextDp[k + 1][0] = (nextDp[k + 1][0] + splitWays) % MOD;
                    }
                }
                dp = nextDp;
            }

            // Calculate the final answer by multiplying total configurations of k chains by k!
            long totalPermutations = 0;
            for (int k = 1; k <= n; k++) {
                long totalWaysForK = (dp[k][0] + dp[k][1]) % MOD;
                long contribution = (totalWaysForK * fact[k]) % MOD;
                totalPermutations = (totalPermutations + contribution) % MOD;
            }

            System.out.println(totalPermutations);
        }

        sc.close();
	}
}

```

---

[View on CodeChef](https://www.codechef.com/problems/OFFBYONE)