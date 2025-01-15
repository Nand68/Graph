// using bfs
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        int[] vis = new int[n];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, -1)); // Start with node 0 and no parent.
        vis[0] = 1;
        
        while (!q.isEmpty()) {
            Pair current = q.peek(); // Fetch the front element in the queue
            q.remove();
            
            int node = current.i;
            int parent = current.j;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int neighbor = adj.get(node).get(i);
                
                if (vis[neighbor] == 0) {
                    q.add(new Pair(neighbor, node));
                    vis[neighbor] = 1;
                } else if (parent != neighbor) {
                    return true; // Cycle detected
                }
            }
        }
        return false;
    }
}

class Pair {
    int i;
    int j;
    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

// using dfs

class Solution {
    int n;

    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        n = adj.size();
        int[] vis = new int[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                if (dfs(i, -1, adj, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int cur, int parent, ArrayList<ArrayList<Integer>> adj, int[] vis) {
        vis[cur] = 1;
        for (int i = 0; i < adj.get(cur).size(); i++) {
            int neighbor = adj.get(cur).get(i);
            if (vis[neighbor] == 0) {
                // If not visited, recurse into it
                if (dfs(neighbor, cur, adj, vis)) {
                    return true;
                }
            } else if (neighbor != parent) {
                // If visited and not the parent, it's a cycle
                return true;
            }
        }
        return false;
    }
}
