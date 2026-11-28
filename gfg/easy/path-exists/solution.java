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