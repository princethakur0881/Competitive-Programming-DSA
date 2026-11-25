class Solution {



    static final long MOD = 1_000_000_007L;



    // Minimum time to reach position x without jump

    static long F(long x, long a, long b) {



        if (x <= a) {

            return x;

        }



        long c = a - b;

        long cycles = (x - a + c - 1) / c;



        return x + 2 * b * cycles;

    }



    // Sum of floor(k / c), k = 0 to n

    static long prefix(long n, long c) {



        if (n < 0) return 0;



        long m = n / c;

        long rem = n % c;



        return c * m * (m - 1) / 2

                + m * (rem + 1);

    }



    // Sum of F(x) from L to R

    static long sumF(long L, long R,

                     long a, long b) {



        if (L > R) return 0;



        long ans = 0;



        // F(x) = x when x <= a

        long end = Math.min(R, a);



        if (L <= end) {



            long n = end - L + 1;



            long sum = (L + end) * n / 2;



            ans = sum % MOD;

        }



        // F(x) = x + 2*b*ceil((x-a)/(a-b))

        long start = Math.max(L, a + 1);



        if (start <= R) {



            long n = R - start + 1;



            long sumX = (start + R) * n / 2;



            long c = a - b;



            long sumCeil = n

                    + prefix(R - a - 1, c)

                    - prefix(start - a - 2, c);



            long extra = (2 * b % MOD)

                    * (sumCeil % MOD) % MOD;



            ans = (ans + sumX % MOD + extra) % MOD;

        }



        return ans;

    }



    public int minTime(int a, int b, int d,

                      int l, int r) {



        long normal = F(d, a, b);



        // Binary search for first beneficial jump

        long low = l;

        long high = r;

        long first = r + 1L;



        while (low <= high) {



            long mid = low + (high - low) / 2;



            if (1 + F(d - mid, a, b) <= normal) {



                first = mid;

                high = mid - 1;



            } else {



                low = mid + 1;

            }

        }



        // Jump lengths where normal movement is better

        long countNormal = first - l;



        long ans = (countNormal % MOD)

                * (normal % MOD) % MOD;



        // Jump lengths where special jump is better

        if (first <= r) {



            long L = d - r;

            long R = d - first;



            long jumpSum = sumF(L, R, a, b);



            long countJump = r - first + 1;



            ans = (ans + jumpSum + countJump) % MOD;

        }



        return (int) ans;

    }

}

