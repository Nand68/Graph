class Solution {
    int n, m;

    public int countDistinctIslands(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int[][] vis = new int[n][m];
        Set<Set<String>> uniqueIslands = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    Set<String> shape = new HashSet<>();
                    dfs(i, j, i, j, grid, vis, shape);
                    uniqueIslands.add(shape);
                }
            }
        }

        return uniqueIslands.size();
    }

    private void dfs(int baseRow, int baseCol, int row, int col, int[][] grid, int[][] vis, Set<String> shape) {
        vis[row][col] = 1;
        // Encode relative position as "(deltaRow, deltaCol)"
        shape.add((row - baseRow) + "," + (col - baseCol));

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        for (int d = 0; d < 4; d++) {
            int nrow = row + drow[d];
            int ncol = col + dcol[d];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && 
                grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                dfs(baseRow, baseCol, nrow, ncol, grid, vis, shape);
            }
        }
    }
}
