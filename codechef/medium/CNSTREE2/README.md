# CNSTREE2

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Consistentree (Construct)

You are given a tree with $N$ vertices. Each vertex $v$ has a value $A_v$, which is one of $-1$, $0$ and $1$.

The tree is called  **consistent**  if it is possible to assign the distinct labels $1, 2, \ldots, N$ to its vertices such that, for every vertex $v$:

- If $A_v = -1$, the label of $v$ is smaller than the label of every neighbor of $v$.
- If $A_v = 1$, the label of $v$ is larger than the label of every neighbor of $v$.
- If $A_v = 0$, the label of $v$ is larger than the label of at least one neighbor of $v$, and smaller than the label of at least one neighbor of $v$.

Decide if the given tree is consistent.
If it is, find any way of assigning labels to the vertices such that the given conditions hold.

### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- Each test case consists of multiple lines of input. The first line of each test case contains a single integer $N$ — the number of vertices of the tree. The second line contains $N$ space-separated integers $A_1, A_2, \ldots, A_N$ — the values of the vertices. The next $N-1$ lines describe the edges. Each of these lines contains two space-separated integers $u$ and $v$, denoting an edge between vertices $u$ and $v$.
### Output Format

For each test case, output on a new line:

- $-1$, if no valid permutation exists;
- otherwise, $N$ space-separated integers $P_1, P_2, \ldots, P_N$ — a valid assignment, where $P_i$ is the vertex assigned to vertex $i$.

If there are multiple valid assignments, you may output any of them.

### Constraints
- $1 \leq T \leq 10^5$
- $2 \leq N \leq 2 \cdot 10^5$
- $A_i$ is one of $-1$, $0$ and $1$.
- $1 \leq u_i, v_i \leq N$, and the given edges form a tree.
- The sum of $N$ over all test cases does not exceed $2 \cdot 10^5$.
### Sample 1:
Input
Output

```
5
2
0 1
1 2
4
-1 0 0 1
1 2
2 3
3 4
5
0 -1 1 -1 1
1 2
1 3
1 4
1 5
5
0 1 1 1 1
1 2
1 3
1 4
1 5
7
-1 1 -1 0 1 -1 1
1 2
2 3
2 4
4 5
4 6
3 7

```

```
-1
1 2 3 4
3 1 4 2 5
-1
1 6 2 5 7 3 4

```

### Explanation:

 **Test case $1$:**  Vertex $1$ has value $0$ but only one neighbor, so it can never have both a smaller and a larger neighbor.

 **Test case $3$:**  Vertex $1$ gets the label $3$, which lies between the labels $1, 2$ of vertices $2, 4$ and the labels $4, 5$ of vertices $3, 5$.

 **Test case $4$:**  Every neighbor of vertex $1$ has value $1$, so its label must be larger than the label of vertex $1$. Then vertex $1$ cannot be larger than any of its neighbors.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-04T14:55:35.567Z  

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
   
    public static void main(String[] args)throws java.lang.Exception {
      
      import java.util.Scanner;
import java.util.ArrayList;

class Codechef {
    static int n;
    static int[] a;
    static ArrayList<Integer>[] adj;
    static boolean[][] dp;
    static int[] parent;
    static int[] order;
    static int[] choice; 
    static ArrayList<Integer>[] dag;
    static int[] inDegree;

    public static void main(String[] args)  throws java.lang.Exceptio{
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        
        while (t-- > 0) {
            n = sc.nextInt();
            a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
            }

            adj = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < n - 1; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj[u].add(v);
                adj[v].add(u);
            }

            // Step 1: Create a safe top-down order using a basic BFS queue
            parent = new int[n + 1];
            order = new int[n + 1];
            boolean[] visited = new boolean[n + 1];
            int head = 0, tail = 0;
            
            order[tail++] = 1; 
            visited[1] = true;
            
            while (head < tail) {
                int curr = order[head++];
                for (int nxt : adj[curr]) {
                    if (!visited[nxt]) {
                        visited[nxt] = true;
                        parent[nxt] = curr;
                        order[tail++] = nxt;
                    }
                }
            }

            // Step 2: Bottom-Up Tree DP check
            dp = new boolean[n + 1][2];
            
            for (int i = n - 1; i >= 0; i--) {
                int u = order[i];
                
                for (int state = 0; state < 2; state++) {
                    int inCount = (u != 1 && state == 1) ? 1 : 0;
                    int outCount = (u != 1 && state == 0) ? 1 : 0;
                    
                    int mustIn = 0, mustOut = 0, flexible = 0;
                    boolean valid = true;
                    
                    for (int v : adj[u]) {
                        if (v == parent[u]) continue;
                        
                        boolean canIn = dp[v][0];  
                        boolean canOut = dp[v][1]; 
                        
                        if (!canIn && !canOut) {
                            valid = false;
                            break;
                        }
                        if (canIn && !canOut) mustIn++;
                        else if (canOut && !canIn) mustOut++;
                        else flexible++;
                    }
                    
                    if (!valid) continue;
                    
                    if (a[u] == -1) {
                        if (inCount == 0 && mustIn == 0) dp[u][state] = true;
                    } else if (a[u] == 1) {
                        if (outCount == 0 && mustOut == 0) dp[u][state] = true;
                    } else { 
                        int totalMaxIn = inCount + mustIn + flexible;
                        int totalMaxOut = outCount + mustOut + flexible;
                        if (totalMaxIn >= 1 && totalMaxOut >= 1 && (inCount + outCount + mustIn + mustOut + flexible >= 2)) {
                            dp[u][state] = true;
                        }
                    }
                }
            }

            if (!dp[1][0] && !dp[1][1]) {
                System.out.println("-1");
                continue;
            }

            // Step 3: Top-Down Orientation. Build a final DAG
            dag = new ArrayList[n + 1];
            inDegree = new int[n + 1];
            for (int i = 1; i <= n; i++) dag[i] = new ArrayList<>();
            choice = new int[n + 1];
            
            int rootState = dp[1][0] ? 0 : 1;
            
            for (int i = 0; i < n; i++) {
                int u = order[i];
                int state = (u == 1) ? rootState : choice[u];
                
                if (u != 1) {
                    if (state == 0) {
                        dag[u].add(parent[u]);
                        inDegree[parent[u]]++;
                    } else {
                        dag[parent[u]].add(u);
                        inDegree[u]++;
                    }
                }
                
                int currentIn = (u != 1 && state == 1) ? 1 : 0;
                int currentOut = (u != 1 && state == 0) ? 1 : 0;
                ArrayList<Integer> flexNodes = new ArrayList<>();
                
                // Handle strict forced children first
                for (int v : adj[u]) {
                    if (v == parent[u]) continue;
                    if (dp[v][0] && !dp[v][1]) {
                        choice[v] = 0; 
                        dag[v].add(u);
                        inDegree[u]++;
                        currentIn++;
                    } else if (!dp[v][0] && dp[v][1]) {
                        choice[v] = 1; 
                        dag[u].add(v);
                        inDegree[v]++;
                        currentOut++;
                    } else {
                        flexNodes.add(v);
                    }
                }
                
                // Assign flexible remaining children to correctly balance counts
                for (int v : flexNodes) {
                    if (a[u] == 0 && currentIn == 0) {
                        choice[v] = 0; 
                        dag[v].add(u);
                        inDegree[u]++;
                        currentIn++; // Updated correctly
                    } else if (a[u] == 0 && currentOut == 0) {
                        choice[v] = 1; 
                        dag[u].add(v);
                        inDegree[v]++;
                        currentOut++; // Updated correctly
                    } else {
                        if (a[u] == -1) {
                            choice[v] = 1;
                            dag[u].add(v);
                            inDegree[v]++;
                            currentOut++;
                        } else {
                            choice[v] = 0;
                            dag[v].add(u);
                            inDegree[u]++;
                            currentIn++;
                        }
                    }
                }
            }

            // Step 4: Run a simple Topological Sort (Kahn's algorithm)
            int[] labels = new int[n + 1];
            int[] queue = new int[n + 1];
            int qHead = 0, qTail = 0;

            for (int i = 1; i <= n; i++) {
                if (inDegree[i] == 0) queue[qTail++] = i;
            }

            int currentLabel = 1;
            while (qHead < qTail) {
                int curr = queue[qHead++];
                labels[curr] = currentLabel++;
                for (int next : dag[curr]) {
                    inDegree[next]--;
                    if (inDegree[next] == 0) queue[qTail++] = next;
                }
            }

            // Print output row
            for (int i = 1; i <= n; i++) {
                System.out.print(labels[i] + (i == n ? "" : " "));
            }
            System.out.println();
        }
        sc.close();
```

---

[View on CodeChef](https://www.codechef.com/problems/CNSTREE2)