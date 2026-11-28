# Path Exists Between Two Vertices

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an undirected graph with  **V**  vertices numbered from 0 to V - 1, represented by an adjacency list  **adj[][]**, where adj[i] contains all vertices adjacent to vertex **i**. Also given two vertices  **u** and  **v**, check whether a path exists between them.

Return true if a path exists, otherwise return false.

 **Examples:** 

```
Input: adj[][] = [[2, 3], [2], [0, 1], [0], [5], [4]], u = 1, v = 5

Output: false
Explanation: There is no path from vertex 1 to vertex 5.
```

```
Input: adj[][] = [[2, 3], [2], [0, 1], [0], [5], [4]], u = 2, v = 3

Output: true
Explanation: We can reach vertex 3 from vertex 2 via vertex 0.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-28T08:49:32.199Z  

```java
class Solution {
    public boolean checkPath(ArrayList<ArrayList<Integer>> adj, int u, int v) {
    Queue<Integer> q = new LinkedList<>();

        q.add(u);

        boolean[] vis  = new boolean[adj.size()];
        vis[u] = true;

        while(!q.isEmpty()){
            Integer node = q.poll();
            for(Integer nei:adj.get(node)){
                if(!vis[nei]){
                    vis[nei] = true;
                    q.add(nei);
                    if(nei == v) return true;
                }
            }
        }
    return false;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/path-exists/1)