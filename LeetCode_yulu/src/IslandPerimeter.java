public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int count = 0, overlap = 0;
        for (int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    if (j > 0 && grid[i][j - 1] == 1) {
                        overlap++;
                    }
                    if (i > 0 && grid[i - 1][j] == 1) {
                        overlap++;
                    }
                }
            }
        }

        return count * 4 - overlap *2;
    }

    public void test() {
        int[][] input = new int[][]{{0, 1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(islandPerimeter(input));
    }
}
