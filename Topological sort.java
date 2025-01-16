// using stack or using DFS

class Solution {
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = adj.size();
        int[] vis = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                dfs(i,vis,adj,st);
            }
        }
        
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
    }
    public static void dfs(int node, int[] vis,ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        vis[node] = 1;
        
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                dfs(it,vis,adj,st);
            }
        }
        st.push(node);
    }
}
