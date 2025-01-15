class Solution {
    int n;
    int m;
    int[] nrow = {-1,0,1,0};
    int[] ncol = {0,1,0,-1};
    public int numEnclaves(int[][] grid) {
        int count = 0;
        n = grid.length;
        m = grid[0].length;
        int[][] vis = new int[n][m];
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 1 && vis[0][i] == 0) {
                dfs(0, i, grid, vis);
            }
            if (grid[n - 1][i] == 1 && vis[n - 1][i] == 0) {
                dfs(n - 1, i, grid, vis);
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && vis[i][0] == 0) {
                dfs(i, 0, grid, vis);
            }
            if (grid[i][m - 1] == 1 && vis[i][m - 1] == 0) {
                dfs(i, m - 1, grid, vis);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
        
    }
    public void dfs(int row, int col, int[][] grid, int[][] vis){
        vis[row][col] = 1;
        for(int i = 0; i < 4; i++){
            int lrow = row + nrow[i];
            int lcol = col + ncol[i];
            if(lrow >= 0 && lrow < n && lcol >= 0 && lcol < m && grid[lrow][lcol] == 1 && vis[lrow][lcol] == 0){
                dfs(lrow,lcol,grid,vis);
            }
        }
    }
}1020. Number of Enclaves
