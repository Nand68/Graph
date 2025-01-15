class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] path = new int[V];
        int[] vis = new int[V];
        
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                if(dfs(i,path,vis,adj)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int node,int[] path, int[] vis,ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        path[node] = 1;
        
        for( int it : adj.get(node)){
            if(vis[it] == 0){
                if(dfs(it,path,vis,adj) == true) return true;
            }
            else if(path[it] == 1) return true;
        }
        path[node] = 0;
        return false;
    }
}
