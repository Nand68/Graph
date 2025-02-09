class Solution {
    public int makeConnected(int n, int[][] connections) {
        Disjoint ds = new Disjoint(n);
        int freeEdges = 0;
        int components = 0;
        for (int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            if (ds.FindUpar(u) == ds.FindUpar(v)) {
                freeEdges++;
            } else {
                ds.unionBySize(u, v);
            }
        }
        for (int i = 0; i < n; i++){
            if ( ds.parents.get(i) == i){
                components++;
            }
        }
        if ( freeEdges >= components-1){
            return components-1;
        }
        return -1;

    }
}

class Disjoint {
    List<Integer> parents = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public Disjoint(int n) {
        for (int i = 0; i < n; i++) {
            parents.add(i);
            size.add(1);
        }
    }

    public int FindUpar(int node){
        if ( node == parents.get(node)){
            return node;
        }
        int u = FindUpar(parents.get(node));
        parents.set(node,u);
        return parents.get(node);
    }

    public void unionBySize(int u, int v) {
        int ulp_u = FindUpar(u);
        int ulp_v = FindUpar(v);

        if (ulp_u == ulp_v)
            return;

        if (size.get(ulp_u) > size.get(ulp_v)) {
            parents.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        } else {
            parents.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }

    }

}
