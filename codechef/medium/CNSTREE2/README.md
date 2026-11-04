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
**Submitted:** 2026-11-04T14:55:02.564Z  

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    static int n;
    static int[] a;
    static ArrayList<Integer>[] adj;
    static int[] parent;
    static int[] order;
    static int[][] dp; // dp[u][0]: path to parent is u->p, dp[u][1]: path is p->u
    static int[] choice; // Stores orientation to parent: 0 means u->p, 1 means p->u
    
    static ArrayList<Integer>[] dag;
    static int[] inDegree;

    public static void main(String[] args)throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
                       if (v == parent[u]) continue;
                        
                        // To connect to child v: 
                        // If we want u->v, child v must accept v as incoming (dp[v][1] must be valid)
                        // If we want v->u, child v must accept v as outgoing (dp[v][0] must be valid)
                        boolean childCanBeIn = (dp[v][1] == 1);
                        boolean childCanBeOut = (dp[v][0] == 1);

                        if (!childCanBeIn && !childCanBeOut) {
                            valid = false;
                            break;
                        }
                        if (childCanBeIn) canProvideIn++;
                        if (childCanBeOut) canProvideOut++;
                    }

                    if (!valid) continue;

                    // Apply constraints given by A[u]
                    if (a[u] == -1) {
                        // All edges must be outgoing from u
                        if (ins > 0 || canProvideIn < childCount) continue;
                        dp[u][state] = 1;
                    } else if (a[u] == 1) {
                        // All edges must be incoming to u
                        if (outs > 0 || canProvideOut < childCount) continue;
                        dp[u][state] = 1;
                    } else { // a[u] == 0
                        // Needs at least one incoming and at least one outgoing edge total
                        int maxPossibleIns = ins + canProvideIn;
                        int maxPossibleOuts = outs + canProvideOut;
                        
                        if (maxPossibleIns >= 1 && maxPossibleOuts >= 1 && (ins + outs + childCount >= 2)) {
                            dp[u][state] = 1;
                        }
                    }
                }
            }

            // Check if root (node 1) is valid. Since root has no parent, we check if it can satisfy any state
            if (dp[1][0] == 0 && dp[1][1] == 0) {
                System.out.println("-1");
                continue;
            }

            // 3. Reconstruct the Graph Directions Top-Down
            dag = new ArrayList[n + 1];
            inDegree = new int[n + 1];
            for (int i = 1; i <= n; i++) dag[i] = new ArrayList<>();
            choice = new int[n + 1];

            // Reconstruct starting at root
            for (int i = 0; i < n; i++) {
                int u = order[i];
                int pState = (u == 1) ? (dp[1][0] == 1 ? 0 : 1) : choice[u];

                int currentOuts = (pState == 0) ? 1 : 0;
                int currentIns = (pState == 1) ? 1 : 0;

                // First handle strict forced directions for children
                for (int v : adj[u]) {
                    if (v == parent[u]) continue;
                    if (dp[v][1] == 1 && dp[v][0] == 0) {
                        // Forced u -> v
                        choice[v] = 1;
                        dag[u].add(v);
                        inDegree[v]++;
                        currentOuts++;
                    } else if (dp[v][0] == 1 && dp[v][1] == 0) {
                        // Forced v -> u
                        choice[v] = 0;
                        dag[v].add(u);
                        inDegree[u]++;
                        currentIns++;
                    }
                }

                // Balance any flexible remaining children to fulfill A[u] == 0 requirements
                for (int v : adj[u]) {
                    if (v == parent[u] || (dp[v][0] != dp[v][1])) continue;

                    if (a[u] == 0 && currentIns == 0) {
                        choice[v] = 0; // Make v -> u
                        dag[v].add(u);
                        inDegree[u]++;
                        currentIns++;
                    } else if (a[u] == 0 && currentOuts == 0) {
                        choice[v] = 1; // Make u -> v
                        dag[u].add(v);
                        inDegree[v]++;
                        currentOuts++;
                    } else {
                        // Default orientation
                        if (a[u] == -1) {
                            choice[v] = 1;
                            dag[u].add(v);
                            inDegree[v]++;
                        } else {
                            choice[v] = 0;
                            dag[v].add(u);
                            inDegree[u]++;
                        }
                    }
                }
            }

            // 4. Kahn's Topological Sort to get sequential labels
            int[] labels = new int[n + 1];
            int[] queue = new int[n + 1];
            int qHead = 0, qTail = 0;

            for (int i = 1; i <= n; i++) {
                if (inDegree[i] == 0) {
                    queue[qTail++] = i;
                }
            }

            int currentLabel = 1;
            while (qHead < qTail) {
                int curr = queue[qHead++];
                labels[curr] = currentLabel++;
                for (int next : dag[curr]) {
                    inDegree[next]--;
                    if (inDegree[next] == 0) {
                        queue[qTail++] = next;
                    }
                }
            }

            // Print the resulting labels
            for (int i = 1; i <= n; i++) {
                System.out.print(labels[i] + (i == n ? "" : " "));
            }
            System.out.println();
        }
        sc.close();
    }
}

```

---

[View on CodeChef](https://www.codechef.com/problems/CNSTREE2)