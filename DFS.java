package DSA.Graph;

import java.util.*;
class DFS{

    public static void DFS(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj,
                           ArrayList<Integer> ls) {

        //marking current node as visited
        vis[node] = true;
        ls.add(node);

        //getting neighbour nodes
        for(Integer it: adj.get(node)) {
            if(vis[it] == false) {
                DFS(it, vis, adj, ls);
            }
        }
    }
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        //boolean array to keep track of visited vertices
        boolean vis[] = new boolean[V+1];
        vis[0] = true;
        ArrayList<Integer> ls = new ArrayList<>();
        DFS(0, vis, adj, ls);
        return ls;
    }

    public static void main(String args[]) {

        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);

        DFS sl = new DFS();
        ArrayList < Integer > ans = sl.dfsOfGraph(5, adj);
        int n = ans.size();
        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i)+" ");
        }
    }
}
// otherway

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        ArrayList<Integer> ans = new ArrayList<>();
        int[] vis = new int[n+1];
        return dfs(adj,ans,vis,0);
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ans ,int[] vis, int node){
        vis[node] = 1;
        ans.add(node);
        
        for(int i = 0; i < adj.get(node).size(); i++){
            if( vis[adj.get(node).get(i)] == 0){
                dfs(adj,ans,vis,adj.get(node).get(i));
            }
        }
        return ans;
    }
}
