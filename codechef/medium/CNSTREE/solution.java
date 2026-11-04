import java.util.*;
import java.lang.*;
import java.io.*;


	
class CodeChef {
    static int n, q;
    static int[] A;
    static ArrayList<Integer>[] adj;
    static int[] parent;
    static int[] order;
    static int[][] dp; // dp[u]: state 0 (u->p), state 1 (p->u)

    public static void main(String[] args)  throws java.lang.Exception{
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();

        while (t-- > 0) {
            n = sc.nextInt();
            q = sc.nextInt();

            A = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                A[i] = sc.nextInt();
            }

            adj = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

            for (int i = 0; i < n - 1; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj[u].add(v);
                adj[v].add(u);
            }

            // Step 1: Lay out the tree top-down from the root using a simple BFS list
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

            dp = new int[n + 1][2];

            // Step 2: Read updates one by one
            while (q-- > 0) {
                int v = sc.nextInt();
                A[v] = -A[v]; // Flip the value of the updated node

                // Recalculate everything bottom-up in one simple clean pass
                for (int i = n - 1; i >= 0; i--) {
                    int u = order[i];
                    
                    for (int state = 0; state < 2; state++) {
                        int inFixed = (u == 1) ? 0 : (state == 1 ? 1 : 0);
                        int outFixed = (u == 1) ? 0 : (state == 0 ? 1 : 0);

                        int reqIn = 0, reqOut = 0, flexible = 0;
                        boolean possible = true;

                        for (int child : adj[u]) {
                            if (child == parent[u]) continue;
                            
                            boolean canIn = (dp[child][0] == 1);  // child points up to u
                            boolean canOut = (dp[child][1] == 1); // child points down from u

                            if (!canIn && !canOut) {
                                possible = false;
                                break;
                            }
                            if (canIn && !canOut) reqIn++;
                            else if (canOut && !canIn) reqOut++;
                            else flexible++;
                        }

                        if (!possible) {
                            dp[u][state] = 0;
                            continue;
                        }

                        // Apply the vertex constraints
                        if (A[u] == -1) {
                            dp[u][state] = (inFixed == 0 && reqIn == 0) ? 1 : 0;
                        } else if (A[u] == 1) {
                            dp[u][state] = (outFixed == 0 && reqOut == 0) ? 1 : 0;
                        } else { // A[u] == 0
                            int minIn = inFixed + reqIn;
                            int minOut = outFixed + reqOut;
                            int low = Math.max(0, 1 - minIn);
                            int high = Math.min(flexible, flexible - 1 + minOut);
                            
                            dp[u][state] = (low <= high) ? 1 : 0;
                        }
                    }
                }

                // Check if the root node (1) has any valid configurations remaining
                if (dp[1][0] == 1 || dp[1][1] == 1) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
        sc.close();
    }
}