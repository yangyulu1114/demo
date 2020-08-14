public class MaxAreaofIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        boolean[][] flag = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && (!flag[i][j])) {
                    int area = AreaofIsland(grid, i, j, flag);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    public int AreaofIsland(int[][] grid, int x, int y, boolean[][] flag) {
        int count = 1;
        flag[x][y] = true;

        if (x > 0 && grid[x - 1][y] == 1 && !flag[x - 1][y]) {
            count += AreaofIsland(grid, x -1, y, flag);
        }

        if (y > 0 && grid[x][y - 1] == 1 && !flag[x][y - 1]) {
            count += AreaofIsland(grid, x, y - 1, flag);
        }
        if (x < grid.length - 1 && grid[x + 1][y] == 1 && !flag[x + 1][y]) {
            count += AreaofIsland(grid, x + 1, y, flag);
        }

        if (y < grid[0].length - 1 && grid[x][y + 1] == 1 && !flag[x][y + 1]) {
            count += AreaofIsland(grid, x, y + 1, flag);
        }
        return count;
    }
//第一种方法是用flag来标记已经算过的，避免重复计算，第二种方法是将读过的标为0，用来替换flag二维数组
    public int maxAreaOfIsland2(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = AreaofIsland(grid, i, j);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    public int AreaofIsland(int[][] grid, int x, int y) {
        int count = 1;
        grid[x][y] = 0;

        if (x > 0 && grid[x - 1][y] == 1) {
            count += AreaofIsland(grid, x -1, y);
        }

        if (y > 0 && grid[x][y - 1] == 1) {
            count += AreaofIsland(grid, x, y - 1);
        }
        if (x < grid.length - 1 && grid[x + 1][y] == 1) {
            count += AreaofIsland(grid, x + 1, y);
        }

        if (y < grid[0].length - 1 && grid[x][y + 1] == 1) {
            count += AreaofIsland(grid, x, y + 1);
        }
        return count;
    }

    public void test() {
        int[][] input = new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland2(input));
    }
}
