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
