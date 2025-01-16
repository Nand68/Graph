class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] indegree = new int[V];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        
        if (ans.size() == V){
            return false;
        }
        return true;
    }
}
