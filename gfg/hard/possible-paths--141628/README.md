# Count Tree Paths With Limited Max Edge Weight

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given a weighted tree with  **n**  nodes, numbered from 1 to n and n - 1 edges, where each edge is represented as [u, v, w] indicating an edge between nodes u and v with weight w.

You are also given an array  **queries[]**, where each queries[i] represents a maximum allowed edge weight.

For each query x, find the number of distinct paths in the tree such that the maximum edge weight along the path is less than or equal to x.

Return an array containing the number of valid paths for each query.

 **Note:** 

- A path from node u to node v and the path from node v to node u are considered the same path.
- A path must contain at least one edge. A path from a node to itself is not considered.

 **Examples:** 

```
Input: n = 3, edges[][] = [[1, 2, 1], [2, 3, 4]], queries[] = [3]
Output: [1]
Explanation:
For x = 3, only the edge [1, 2, 1] has weight less than or equal to 3.
Therefore, the only valid path is: 1 -> 2
The path 1 -> 3 contains an edge of weight 4, so it is not valid.
Hence, the answer is 1.
```

```
Input: n = 7, edges[][] = [[1, 2, 3], [2, 3, 1], [2, 4, 9], [3, 6, 7], [3, 5, 8], [5, 7, 4]], queries[] = [1, 3, 5]
Output: [1, 3, 4]
Explanation: For x = 1, only the edge [2, 3, 1] satisfies the condition. 
Therefore, the only valid path is 2 -> 3, giving an answer of 1.
For x = 3, the edges [2, 3, 1] and [1, 2, 3] can be used. 
They form three valid paths: 1 -> 2, 2 -> 3, and 1 -> 3. 
For x = 5, the edges with weights 1, 3, and 4 can be used. 
They form four valid paths: 1 -> 2, 2 -> 3, 1 -> 3, and 5 -> 7.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-03T15:40:31.652Z  

```java
class Solution {
    int[] parent, size;
    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    void union(int u, int v, long[] count) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv) return;
        if (size[pu] < size[pv]) {
            int temp = pu;
            pu = pv;
            pv = temp;
        }
        count[0] += (long) size[pu] * size[pv];
        parent[pv] = pu;
        size[pu] += size[pv];
    }
    public ArrayList<Integer> maximumWeight(
        int n, int[][] edges, int[] queries) {
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        // Sort edges by weight
        Arrays.sort(edges, (a, b) ->
            Integer.compare(a[2], b[2]));
        // Store query with original index
        int[][] q = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }
        // Sort queries
        Arrays.sort(q, (a, b) ->
            Integer.compare(a[0], b[0]));
        Integer[] ans = new Integer[queries.length];
        int j = 0;
        long[] count = {0};
        for (int i = 0; i < q.length; i++) {
            int limit = q[i][0];
            while (j < edges.length &&
                   edges[j][2] <= limit) {
                int u = edges[j][0];
                int v = edges[j][1];
                union(u, v, count);
                j++;
            }
            ans[q[i][1]] = (int) count[0];
        }
        return new ArrayList<>(Arrays.asList(ans));  
        
    }
};
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/possible-paths--141628/1)