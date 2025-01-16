class Solution {

    static class Edge {
        int end;
        int weight;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    public int[] shortestPath(int v, int e, int[][] edges) {
        // Step1 --> prepare adjacency list using edges and weight
        List<List<Edge>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adjacencyList.get(edges[i][0]).add(new Edge(edges[i][1], edges[i][2]));
        }
        // step2 --> Do Topo Sort using DFS
        boolean[] visited = new boolean[v];
        Stack<Integer> nodeStack = new Stack<>();

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfsTopo(i, visited, adjacencyList, nodeStack);
            }
        }
        //System.out.println(nodeStack);

        int[] distance = new int[v];
        Arrays.fill(distance, (int) 1e9);
        distance[0] = 0;
        while (!nodeStack.isEmpty()) {
            int currNode = nodeStack.pop();

            // now for all adjacent nodes of current node --> go and update distance
            for (int i = 0; i < adjacencyList.get(currNode).size(); i++) {
                Edge currEdge = adjacencyList.get(currNode).get(i);
                int end = currEdge.end;
                int wt = currEdge.weight;

                if (distance[currNode] + wt < distance[end]) {
                    distance[end] = wt + distance[currNode];
                }
            }
        }
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == 1e9) {
                distance[i] = -1;
            }
            //System.out.println(distance[i]);
        }
        return distance;
    }

    private void dfsTopo(int currNode, boolean[] visited, List<List<Edge>> adjacencyList, Stack<Integer> nodeStack) {
        visited[currNode] = true;
        for (int i = 0; i < adjacencyList.get(currNode).size(); i++) {
            int end = adjacencyList.get(currNode).get(i).end;
            if (!visited[end]) {
                dfsTopo(end, visited, adjacencyList, nodeStack);
            }
        }
        nodeStack.push(currNode);
    }
}
