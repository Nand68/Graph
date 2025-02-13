class Solution {
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        int V=adj.size();
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, adj, st);
            }
        }

        ArrayList<ArrayList<Integer>> adjT = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < V; i++) {
            adjT.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < V; i++) {
            vis[i] = 0;
            for (Integer it : adj.get(i)) {
                // i -> it
                // it -> i
                adjT.get(it).add(i);
            }
        }
        int scc = 0;
        while (!st.isEmpty()) {
            int node = st.peek();
            st.pop();
            if (vis[node] == 0) {
                scc++;
                dfs3(node, vis, adjT);
            }
        }
        return scc;
    }
    private void dfs(int node, int []vis, ArrayList<ArrayList<Integer>> adj,
                     Stack<Integer> st) {
        vis[node] = 1;
        for (Integer it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs(it, vis, adj, st);
            }
        }
        st.push(node);
    }
     private void dfs3(int node, int[] vis, ArrayList<ArrayList<Integer>> adjT) {
        vis[node] = 1;
        for (Integer it : adjT.get(node)) {
            if (vis[it] == 0) {
                dfs3(it, vis, adjT);
            }
        }
    }
}
