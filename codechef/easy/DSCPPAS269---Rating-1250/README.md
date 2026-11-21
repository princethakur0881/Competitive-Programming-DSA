# DSCPPAS269 - Rating 1250

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Mountain Peak

You are given a list of integers $heights$ representing the heights of $N$ mountain peaks. For each peak, you need to find the height of the next higher peak that comes after it in the list. If there is no higher peak after a given peak, return $-1$ for that peak.

### Input Format
- The first line contains one integer $n$, the size of the list of integers. - Next line contains $n$ integers $heights[0],heights[1]...heights[n]$, representing the peaks.
### Output Format
- For each peak, print the next higher peak that comes after it in the list. If there is no higher peak for a peak than print $-1$.
### Constraints
- $1 \leq n \leq 100000$
- $0 \leq heights[i] \leq 1000000$
### Sample 1:
Input
Output

```
2
1 2
```

```
2 -1
```

### Explanation:

The next greater element for 1 is 2 and for 2 there is no next greater element so for 2 it will be -1.

### Sample 2:
Input
Output

```
4
6 5 3 6
```

```
-1 6 6 -1
```

### Explanation:

For the first 6 there is no element greater than 6 on its right so the peak for the first 6 is -1. For 5, 6 is the next peak as it is on the right side and is greater than 5. For the next element 3, 6 is the peak as it is on the right side and is greater than 3, for the last 6, no peak is there on the right side so -1 is there.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-21T18:09:38.202Z  

```java
import java.util.*;

public class Main {
    public static int[] nextHigherPeak(int[] heights) {
        int n = heights.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; ++i) {
            while (!st.isEmpty() && heights[i] > heights[st.peek()]) {
                int idx = st.pop();
                result[idx] = heights[i];
            }
            st.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];

        for (int i = 0; i < n; ++i) {
            heights[i] = sc.nextInt();
        }

        int[] result = nextHigherPeak(heights);

        for (int height : result) {
            System.out.print(height + " ");
        }
        System.out.println();
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/DSCPPAS269)