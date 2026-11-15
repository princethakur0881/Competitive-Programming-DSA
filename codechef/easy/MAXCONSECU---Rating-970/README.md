# MAXCONSECU - Rating 970

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

_Description not available._

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-15T14:11:38.070Z  

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	 Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] v = new int[n];
            int totalSum = 0;
            int smallestElement = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                v[i] = scanner.nextInt();
                totalSum += v[i];
                smallestElement = Math.min(smallestElement, v[i]);
            }
            System.out.println(totalSum - smallestElement);
        }
        scanner.close();

	}
}

```

---

[View on CodeChef](https://www.codechef.com/problems/MAXCONSECU)