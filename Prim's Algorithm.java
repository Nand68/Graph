class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[] vis = new int[V];
        pq.add(new Pair(0, 0)); // Start from node 0 with weight 0
        int sum = 0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int wt = current.distance;
            int node = current.node;

            if (vis[node] == 1) continue; // If already visited, skip
            vis[node] = 1; // Mark the node as visited
            sum += wt; // Add the weight to the sum

            // Explore the adjacent nodes
            for (int[] edge : adj.get(node)) {
                int adjNode = edge[0]; // The adjacent node
                int edW = edge[1]; // The weight of the edge

                if (vis[adjNode] == 0) { // If the adjacent node is not visited
                    pq.add(new Pair(edW, adjNode)); // Add it to the priority queue
                }
            }
        }
        return sum; // Return the total weight of the MST
    }
}

class Pair {
    int node;
    int distance;

    public Pair(int distance, int node) {
        this.node = node;
        this.distance = distance;
    }
}
