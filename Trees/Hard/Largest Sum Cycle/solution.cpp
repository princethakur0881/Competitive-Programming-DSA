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