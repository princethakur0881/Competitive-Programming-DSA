import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int maxVal = 0;
            
            // Read array and find the maximum value
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (a[i] > maxVal) {
                    maxVal = a[i];
                }
            }
            
            // dist[i][0] = distance to closest max value with even steps
            // dist[i][1] = distance to closest max value with odd steps
            int[][] dist = new int[n][2];
            for (int i = 0; i < n; i++) {
                dist[i][0] = -1;
                dist[i][1] = -1;
            }
            
            // Queues for BFS
            int[] qNode = new int[2 * n + 5];
            int[] qParity = new int[2 * n + 5];
            int head = 0, tail = 0;
            
            // Multi-source BFS starting from all cells containing the max value
            for (int i = 0; i < n; i++) {
                if (a[i] == maxVal) {
                    dist[i][0] = 0; // 0 steps is even
                    qNode[tail] = i;
                    qParity[tail] = 0;
                    tail++;
                }
            }
            
            // Standard BFS traversal
            while (head < tail) {
                int curr = qNode[head];
                int p = qParity[head];
                head++;
                
                int nextP = 1 - p; // Flips 0 to 1, or 1 to 0
                
                // Left neighbor (cyclical wrapper)
                int left = (curr == 0) ? n - 1 : curr - 1;
                if (dist[left][nextP] == -1) {
                    dist[left][nextP] = dist[curr][p] + 1;
                    qNode[tail] = left;
                    qParity[tail] = nextP;
                    tail++;
                }
                
                // Right neighbor (cyclical wrapper)
                int right = (curr == n - 1) ? 0 : curr + 1;
                if (dist[right][nextP] == -1) {
                    dist[right][nextP] = dist[curr][p] + 1;
                    qNode[tail] = right;
                    qParity[tail] = nextP;
                    tail++;
                }
            }
            
            int maxOddSteps = 0;
            int maxEvenSteps = 0;
            boolean possibleOdd = true;
            boolean possibleEven = true;
            
            // Check max required steps for both even and odd targets
            for (int i = 0; i < n; i++) {
                if (dist[i][1] == -1) possibleOdd = false;
                else maxOddSteps = Math.max(maxOddSteps, dist[i][1]);
                
                if (dist[i][0] == -1) possibleEven = false;
                else maxEvenSteps = Math.max(maxEvenSteps, dist[i][0]);
            }
            
            int ansOdd = Integer.MAX_VALUE;
            if (possibleOdd) {
                // If max needed steps is even, we must round up to the next odd time
                ansOdd = (maxOddSteps % 2 == 1) ? maxOddSteps : maxOddSteps + 1;
            }
            
            int ansEven = Integer.MAX_VALUE;
            if (possibleEven) {
                // If max needed steps is odd, we must round up to the next even time
                ansEven = (maxEvenSteps % 2 == 0) ? maxEvenSteps : maxEvenSteps + 1;
            }
            
            int finalAns = Math.min(ansOdd, ansEven);
            
            if (finalAns == Integer.MAX_VALUE) {
                System.out.println("-1");
            } else {
                System.out.println(finalAns);
            }
        }
        
        sc.close();

	}
}
