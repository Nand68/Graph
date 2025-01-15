class Solution {
    int n;
    int m;
    public int[][] updateMatrix(int[][] mat) {
        n = mat.length;
        m = mat[0].length;
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = 1;
                }
            }
        }
        while (!q.isEmpty()){
            int row = q.peek().i;
            int col = q.peek().j;
            int time = q.peek().time;
            q.remove();
            for(int i = 0; i < 4; i++){
                int lrow = row + drow[i];
                int lcol = col + dcol[i];
                int newtime = time + 1;
                if(lrow >= 0 && lrow < n && lcol >= 0 && lcol < m && vis[lrow][lcol] == 0){
                    vis[lrow][lcol] = 1;
                    mat[lrow][lcol] = newtime;
                    q.add(new Pair(lrow,lcol,newtime));
                }
            }
        }
        return mat;
    }
}

class Pair{
    int i;
    int j;
    int time;
    Pair(int i, int j,int time){
        this.i = i;
        this.j = j;
        this.time = time;
    }
}
