//using DSF
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i = 0; i < n; i++){
            if(color[i] == -1){
                if(dfs(i,0,color,graph) == false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int node,int col,int[] color,int[][] adj){
        color[node] = col;
        for( int it : adj[node]){
            if(color[it] == -1){
                if(dfs(it,1-col,color,adj) == false){
                    return false;
                }
            }
            else if(color[it] == col){
                return false;
            }
        }
        return true;
    }
}

// using BFS

public boolean isBipartite(int[][] graph) {
    int n = graph.length;
    int[] color = new int[n];
    Arrays.fill(color, -1);

    for (int i = 0; i < n; i++) {
        if (color[i] == -1) { 
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            color[i] = 0;

            while (!q.isEmpty()) {
                int node = q.poll();

                for (int it : graph[node]) {
                    if (color[it] == -1) {
                        color[it] = 1 - color[node];
                        q.add(it);
                    } else if (color[it] == color[node]) {
                        return false; 
                    }
                }
            }
        }
    }
    return true;
}
