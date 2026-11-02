# Largest Sum Cycle

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given an array   edge[]   of size   n , there are   n   cells numbered from   0   to   n - 1 . Each cell has at most one outgoing edge.

For every cell i:

- edge[i] is the cell reached from i in one step.
- edge[i] = -1 means that cell i has no outgoing edge.

A cycle is a sequence of cells where, by following the outgoing edges, we eventually return to the starting cell. The sum of a cycle is the sum of the indices of all cells in that cycle.

Return the maximum cycle sum. If there is no cycle, return -1.

  Examples:  

```
Input: edge[] = [1, 2, 0, -1]
Output: 3
Explanation: There is only one cycle in the graph i.e. 0 -> 1 -> 2 -> 0. Sum of the cell index in that cycle = 0 + 1 + 2 = 3.

```

```
Input: edge[] = [2, 0, -1, 2]
Output: -1
Explanation: There is no cycle in the graph. The edges are 1 -> 0 -> 2 <- 3. Hence, 2 has no outgoing edge, so no cycle exists.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-02T16:22:09.168Z  

```java
class Solution {
    public int largestSumCycle(int[] edge) {
       int n = edge.length;
              int[] state = new int[n];
              long best = -1;

              for (int start = 0; start < n; start++) {
                  if (state[start] != 0)
                      continue;

                  int node = start;
                  while (node != -1 && state[node] == 0) {
                      state[node] = 1;
                      node = edge[node];
                  }

                  if (node != -1 && state[node] == 1) {
                      long sum = 0;
                      int cur = node;
                      do {
                          sum += cur;
                          cur = edge[cur];
                      } while (cur != node);
                      if (sum > best)
                          best = sum;
                  }

                  node = start;
                  while (node != -1 && state[node] == 1) {
                      state[node] = 2;
                      node = edge[node];
                  }
              }
              return (int) best;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/largest-sum-cycle--170645/1)