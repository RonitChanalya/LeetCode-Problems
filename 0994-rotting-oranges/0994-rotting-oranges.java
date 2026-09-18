class Solution {
    class Pair {
        int left;
        int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    int[] x = {-1, 1, 0, 0};
    int[] y = {0, 0, -1, 1};

    public boolean valid(int i, int j, int n, int m) {
        if(i < 0 || i >= n || j < 0 || j >= m) return false;
        return true;
    }

    public int orangesRotting(int[][] adj) {
        int n = adj.length;
        int m = adj[0].length;
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        int time = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(adj[i][j] == 2) {
                    q.offer(new Pair(i, j));
                    adj[i][j] = -2;
                } else if(adj[i][j] == 1) fresh++;
            }
        }

        while(!q.isEmpty() && fresh > 0) {
            time++;
            int s = q.size();
            while(s != 0) {
                s--;
                Pair p = q.poll();
                int r = p.left;
                int c = p.right;
                for(int k = 0; k < 4; k++) {
                    int row = r + x[k];
                    int col = c + y[k];
                    if(valid(row, col, n, m) && adj[row][col] == 1) {
                        q.offer(new Pair(row, col));
                        adj[row][col] = -2;
                        fresh--;
                    }
                }
            }
        } 
        if(fresh > 0) return -1;
        return time;
    }
}