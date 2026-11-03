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