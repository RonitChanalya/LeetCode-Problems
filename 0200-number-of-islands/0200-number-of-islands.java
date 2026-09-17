class Solution {
    int[] x = {-1, 1, 0, 0};
    int[] y = {0, 0, -1, 1};

    public int numIslands(char[][] adj) {
        int n = adj.length;
        int m = adj[0].length;

        int res = 0;

        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (adj[i][j] == '1' && !vis[i][j]) {
                    dfs(adj, n, m, i, j, vis);
                    res++;
                }
            }
        }

        return res;
    }

    public void dfs(char[][] adj, int n, int m, int i, int j, boolean[][] vis) {
        vis[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int row = i + x[k];
            int col = j + y[k];

            if (valid(row, col, n, m)
                    && adj[row][col] == '1'
                    && !vis[row][col]) {

                dfs(adj, n, m, row, col, vis);
            }
        }
    }

    public boolean valid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}