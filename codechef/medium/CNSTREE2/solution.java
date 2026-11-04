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

            // 1. Line up nodes from root down to leaves using a basic BFS array order
            parent = new int[n + 1];
            order = new int[n + 1];
            boolean[] visited = new boolean[n + 1];
            
            int head = 0, tail = 0;
            order[tail++] = 1;
            visited[1] = true;
            
            while (head < tail) {
                int curr = order[head++];
                for (int neighbor : adj[curr]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        parent[neighbor] = curr;
                        order[tail++] = neighbor;
                    }
                }
            }

            // 2. Tree DP Bottom-Up: Figure out if subtrees can be validly oriented
            dp = new int[n + 1][2];
            boolean possible = true;

            for (int i = n - 1; i >= 0; i--) {
                int u = order[i];
                
                // Track conditions for children
                int childCount = 0;
                for (int v : adj[u]) {
                    if (v != parent[u]) childCount++;
                }

                // Loop over both choices for parent direction: 
                // state 0: u->parent, state 1: parent->u
                for (int state = 0; state < 2; state++) {
                    int outs = (state == 0) ? 1 : 0;
                    int ins = (state == 1) ? 1 : 0;

                    boolean valid = true;
                    int canProvideIn = 0;
                    int canProvideOut = 0;

                    for (int v : adj[u]) {
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
