public class MinimumPathSum {
    //本题要注意边界条件的判断
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j > 0 && i > 0) {
                    grid[i][j] += Math.min(grid[i][j - 1], grid[i- 1][j]);
                } else if (i > 0) {
                    grid[i][j] += grid[i - 1][j];
                } else if (j > 0){
                    grid[i][j] += grid[i][j - 1];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public void test() {
        int[][] grid = new int[][]{{1,2},{1,1}};
        System.out.println(minPathSum(grid));
    }
}
