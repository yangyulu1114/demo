import java.util.LinkedList;
import java.util.Queue;
//本题的思路就是将1的上下左右的数都清空，最后看有几个1

public class NumberofIslands {
    public int numIslands(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    bfs(grid, i, j);
                }
            }
        }
        return num;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') { //注意这里是字符0，不是数字0
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
    }

    public void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        grid[i][j] = '0';
        int[] dx = new int[]{-1, 0, 1, 0}, dy = new int[]{0, -1, 0, 1};
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0], y = pos[1];
            for (int k = 0; k < dx.length; k++) {
                int x0 = x + dx[k], y0 = y + dy[k];
                if (x0 >= 0 && x0 < grid.length && y0 >= 0 && y0 < grid[0].length && grid[x0][y0] == '1') {
                    grid[x0][y0] = '0';
                    queue.add(new int[]{x0, y0});
                }
            }
        }
    }

    public void test() {
        char[][] grid = new char[][]{{'1', '1', '0', '0', '0'},
                                    {'1', '1', '0', '0', '0'},
                                    {'0', '0', '1', '0', '0'},
                                    {'0', '0', '0', '1', '1'}};
        System.out.println(numIslands(grid));
    }
}
