import java.util.*;
import java.lang.*;
import java.io.*;

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

    public static void main(String[] args)  throws java.lang.Exception {
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
    }
}