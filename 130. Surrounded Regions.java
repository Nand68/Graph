class Solution {
    int n;
    int m;
    int[] drow = {-1,0,1,0};
    int[] dcol = {0,1,0,-1};
    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;
        int[][] vis = new int[n][m];
        
        // DFS on the boundary 'O's
        for(int i = 0; i < m; i++) {
            if(board[0][i] == 'O' && vis[0][i] == 0) {
                dfs(0, i, board, vis);
            }
            if(board[n-1][i] == 'O' && vis[n-1][i] == 0) {
                dfs(n-1, i, board, vis);
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(board[i][0] == 'O' && vis[i][0] == 0) {
                dfs(i, 0, board, vis);
            }
            if(board[i][m-1] == 'O' && vis[i][m-1] == 0) {
                dfs(i, m-1, board, vis);
            }
        }
        
        // Replace unvisited 'O' with 'X' (surrounded region)
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 'O' && vis[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
        
        // Convert back the visited 'O' cells to 'O'
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(vis[i][j] == 1) {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    public void dfs(int row, int col, char[][] board, int[][] vis) {
        vis[row][col] = 1;

        for(int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && board[nrow][ncol] == 'O' && vis[nrow][ncol] == 0) {
                dfs(nrow, ncol, board, vis);
            }
        }
    }
}
