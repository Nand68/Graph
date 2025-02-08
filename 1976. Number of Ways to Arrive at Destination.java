import java.util.*;

class Pair {
    long first; // Distance (long to handle large weights)
    int second; // Node index

    Pair(long first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = (int) 1e9 + 7;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build adjacency list
        for (int[] road : roads) {
            adj.get(road[0]).add(new Pair(road[2], road[1])); // (weight, to)
            adj.get(road[1]).add(new Pair(road[2], road[0])); // (weight, to)
        }

        long[] dist = new long[n]; // Distance array
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        int[] ways = new int[n]; // Ways array
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.first, b.first));
        pq.add(new Pair(0, 0)); // (distance, node)

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            long currDist = current.first;
            int node = current.second;


            for (Pair neighbor : adj.get(node)) {
                int adjNode = neighbor.second;
                long edgeWeight = neighbor.first;

                if (currDist + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = currDist + edgeWeight;
                    ways[adjNode] = ways[node];
                    pq.add(new Pair(dist[adjNode], adjNode));
                } else if (currDist + edgeWeight == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1] % mod;
    }
}
