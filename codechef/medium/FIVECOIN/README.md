# FIVECOIN

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Exact Change

You want to pay exactly $N$ rupees to a shop.
You have  **one**  coin worth $5$ rupees and an unlimited supply of coins worth $1$ rupee each.

Find the minimum number of coins you must use to pay exactly $N$ rupees. You may use the $5$-rupee coin at most once.

### Input Format
- The first and only line of input will contain a single integer $N$ — the amount to be paid, in rupees.
### Output Format

Output a single integer: the minimum number of coins required.

### Constraints
- $1 \leq N \leq 20$
### Sample 1:
Input
Output

```
3

```

```
3

```

### Explanation:

Use three $1$-rupee coins.

### Sample 2:
Input
Output

```
5

```

```
1

```

### Explanation:

Use the $5$-rupee coin.

### Sample 3:
Input
Output

```
8

```

```
4

```

### Explanation:

Use the $5$-rupee coin and three $1$-rupee coins.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-04T14:33:56.259Z  

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	Scanner sc = new Scanner(System.in);
	int n =sc.nextInt();
	if(n>=5){
	    System.out.println(1+(n-5));
	}
	else{
	    System.out.println(n);
	}

	}
}

```

---

[View on CodeChef](https://www.codechef.com/problems/FIVECOIN)