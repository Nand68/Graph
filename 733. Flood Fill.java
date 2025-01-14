class Solution {
    int n, m;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if (oldColor == color) return image;

        n = image.length;
        m = image[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));

        image[sr][sc] = color;

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int row = q.peek().i;
            int col = q.peek().j;
            q.poll();

            for (int i = 0; i < 4; i++) {
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];
                
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && image[nRow][nCol] == oldColor) {
                    q.add(new Pair(nRow, nCol));
                    image[nRow][nCol] = color;
                }
            }
        }
        return image;
    }
}

class Pair {
    int i, j;
    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
