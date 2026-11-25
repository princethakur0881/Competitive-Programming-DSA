# Geek's Destination with Special Jump

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Geek starts at position  **0**  on the positive X-axis and needs to reach or pass position  **d**  on the positive X-axis.

Geek normally follows a repeating movement pattern:

- Move forward by a units, taking a seconds.
- Move backward by b units, taking b seconds.

Geek also has a special jump that moves him exactly  **j**  units forward in 1 second. He can use it at any time, even in the middle of a forward or backward movement, and the journey ends immediately after the jump.

Given five integers  **a**,  **b**,  **d**,  **l**, and  **r**. For every integer j in the range [l, r], find the minimum time required for Geek to reach or pass position d. He may either use the special jump or reach the destination using normal movement alone, whichever takes less time.

Return the sum of the minimum times for all jump lengths from l to r. Since, the answer can be large, return modulo 109 + 7. 

 **Note:** Each jump length is considered independently.

 **Examples:** 

```
Input: a = 2, b = 1, d = 5, l = 3, r = 4
Output: 5
Explanation: 
For j = 3, Geek moves 2 units forward, then takes a jump of 3 units to reach the destination. The minimum time required is 3 seconds.
For j = 4, Geek moves 1 unit forward, then takes a jump of 4 units to reach the destination. The minimum time required is 2 seconds.
Total sum for the range [l, r] = 3 + 2 = 5.
```

```
Input: a = 4, b = 2, d = 8, l = 2, r = 4
Output: 26
Explanation:
For j = 2, Geek moves 4 units forward, then 2 units backward. She then moves 4 units forward again and takes a jump of 2 units to reach the destination. The minimum time required is 11 seconds.
For j = 3, Geek moves 4 units forward, then 2 units backward. She then moves 3 units forward and takes a jump of 3 units to reach the destination. The minimum time required is 10 seconds.
For j = 4, Geek moves 4 units forward, then takes a jump of 4 units to reach the destination. The minimum time required is 5 seconds.
Total sum for the range [l, r] = 11 + 10 + 5 = 26.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-25T07:01:18.998Z  

```java
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


```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/geek-and-her-destination--145724/1)