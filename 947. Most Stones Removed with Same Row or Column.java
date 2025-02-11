class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = 0;
        int maxCol = 0;
        int count = 0;
        for ( int it = 0; it < n; it++){
            maxRow = Math.max(maxRow,stones[it][0]);
            maxCol = Math.max(maxCol,stones[it][1]);
        }
        Disjoint ds = new Disjoint(maxRow+maxCol+2);
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int it = 0; it < n; it++){
            int row = stones[it][0];
            int col = maxRow + stones[it][1] + 1;
            ds.unionBySize(row,col);
            map.put(row,1);
            map.put(col,1); 
        }
        for( Map.Entry<Integer,Integer> it : map.entrySet()){
            if (ds.FindPar(it.getKey()) == it.getKey()){
                count++;
            }
        }
        return n-count;
    }
}

class Disjoint {
    ArrayList<Integer> parents = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();
    public Disjoint(int n) {
        for (int i = 0; i < n; i++) {
            parents.add(i);
            size.add(1);
        }
    }
    public int FindPar(int node) {
        if (parents.get(node) == node) {
            return node;
        }
        int u = FindPar(parents.get(node));
        parents.set(node, u);
        return parents.get(node);
    }
    public void unionBySize(int u, int v) {
        int ulp_u = FindPar(u);
        int ulp_v = FindPar(v);
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
