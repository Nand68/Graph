class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int ans = Integer.MIN_VALUE;
        Disjoint ds = new Disjoint(n*n);
        int[] nrow = {-1,0,1,0};
        int[] ncol = {0,1,0,-1};
        for ( int i = 0; i < n; i++){
            for ( int j = 0; j < n; j++){
                if (grid[i][j] == 0) continue;

                for ( int k = 0; k < 4; k++){
                    int lrow = nrow[k] + i;
                    int lcol = ncol[k] + j; 
                    if ( lrow < n && lrow >= 0 && lcol < n && lcol >=0 && grid[lrow][lcol] == 1){
                        int node = ( i * n) + j;
                        int adjNode = ( lrow * n) + lcol;
                        ds.unionBySize(node,adjNode);
                    }
                }
            }
        }
        for ( int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 0){ 
                    Set<Integer> set = new HashSet<>();
                    for ( int k = 0; k < 4; k++){
                        int lrow = nrow[k] + i;
                        int lcol = ncol[k] + j;
                        if (lrow < n && lrow >= 0 && lcol < n && lcol >=0 &&  grid[lrow][lcol] == 1){
                            set.add(ds.FindPar((lrow*n)+lcol));
                        }
                    }
                    int total = 1;
                    for (int it : set){
                        total = total + ( ds.size.get(ds.FindPar(it)));
                    }
                    ans = Math.max(ans,total);
                }
            }
        }
        for ( int i = 0; i  < n*n; i++){
            ans = Math.max(ans, ds.size.get(ds.FindPar(i)));
        }
        return ans;
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
