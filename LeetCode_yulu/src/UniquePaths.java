public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] path = new int[m][n];
        path[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j > 0) {
                    path[i][j] += path[i][j - 1];
                }
                if (i > 0) {
                    path[i][j] += path[i - 1][j];
                }
            }
        }
        return path[m - 1][n - 1];
    }
}
