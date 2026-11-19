# STONE_PILE - Rating 1190

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

_Description not available._

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-19T15:16:45.269Z  

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
 Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases

        while (T-- > 0) {
            int n = sc.nextInt(); // Number of pearls
            int k = sc.nextInt(); // Number of left shifts

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // Print from k to the end
            for (int i = k; i < n; i++) {
                System.out.print(arr[i] + " ");
            }

            // Print from 0 to k - 1
            for (int i = 0; i < k; i++) {
                System.out.print(arr[i] + " ");
            }

            System.out.println(); // New line for next test case
        }
	}
}

```

---

[View on CodeChef](https://www.codechef.com/problems/STONE_PILE)