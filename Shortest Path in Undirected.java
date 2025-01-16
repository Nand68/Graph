class Solution {
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int n = adj.size();
        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(src);
        dist[src] = 0;
        visited[src] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    dist[neighbor] = dist[node] + 1;
                }
            }
        }

        return dist;
    }
}
