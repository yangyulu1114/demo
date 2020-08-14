public class MagicSquaresInGrid {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (isMagicSquares(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isMagicSquares(int[][] grid, int i, int j) {
        int[] count = new int[16];
        for (int a = 0; a <= 2; a++) {
            for (int b = 0; b <= 2; b++) {
                count[grid[i + a][j + b]]++;
            }
        }
        for (int a = 1; a <= 9; a ++) {
            if (count[a] != 1) {
                return false;
            }
        }
        int sum1 = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
        int sum2 = grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2];
        int sum3 = grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];
        int sum4 = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];
        int sum5 = grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1];
        int sum6 = grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2];
        int sum7 = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
        int sum8 = grid[i + 2][j] + grid[i + 1][j + 1] + grid[i][j + 2];
        return sum1 == sum2 && sum1 == sum3 && sum1 == sum4 && sum1 == sum5 && sum1 == sum6
                && sum1 == sum7 && sum1 == sum8;
    }

    public void test() {
        int[][] input = new int[][]{{10,3,5},{1,6,11},{7,9,2}};
        System.out.println(numMagicSquaresInside(input));
    }
}
