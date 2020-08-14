public class MaximalSquare {
  //暴力法，时间复杂度是O（mn）的平方，空间复杂度是O(1)
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length, maxslen = 0;
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == '0') {
                    continue;
                }
                int slen = 1;
                boolean flag = true;
                while (i + slen < m && j + slen < n && flag) {
                    for (int k = i; k <= i + slen; k++) {
                        if (matrix[k][j + slen] == '0') {
                            flag = false;
                            break;
                        }
                    }
                    for (int k = j; k <= j + slen; k++) {
                        if (matrix[i + slen][k] == '0') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        slen++;
                    }
                }
                maxslen = Math.max(maxslen, slen);
            }
        }
        return maxslen * maxslen;
    }
//动态规划，时间复杂度和空间复杂度都是O（mn），
    public int maximalSquare2(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length, maxSquare = 0;
        int[][] square = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                } else {
                    square[i][j] = 1;
                }
                if (i > 0 && j > 0) {
                    int min = Math.min(square[i - 1][j - 1], square[i - 1][j]);
                    min = Math.min(min, square[i][j - 1]);
                    square[i][j] = min + 1;
                }
                maxSquare = Math.max(maxSquare, square[i][j]);
            }
        }
        return maxSquare * maxSquare;
    }
//3对2的代码就行了优化，因为最上面那一行和最左边那一列比较特俗，需要进行i,j的判断，下面这样写就可以省去if操作
    public int maximalSquare3(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length, maxSquare = 0;
        int[][] square = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    square[i][j] = Math.min(Math.min(square[i - 1][j - 1], square[i][j - 1]), square[i - 1][j]);
                    maxSquare = Math.max(maxSquare, square[i][j]) + 1;
                }
            }
        }
        return maxSquare * maxSquare;
    }
//这个方法在上面的基础上优化了空间，空间复杂度降低到O（n），因为只用保存部分变量
    public int maximalSquare4(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length, pre = 0, maxSquare = 0;
        int[] square = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int temp = square[j];
                if (matrix[i - 1][j - 1] == '1') {
                    square[j] = Math.min(Math.min(square[j - 1], square[j]), pre) + 1;
                    maxSquare = Math.max(maxSquare, square[j]);
                } else {
                    square[j] = 0;
                }
                pre = temp;
            }
        }
        return maxSquare * maxSquare;
    }

    public void test() {
        char[][] matrix = new char[][]{
                {'1', '0', '1', '1', '1'},
                {'0', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '1'},
                {'1', '1', '0', '1', '1'},
                {'0', '1', '1', '1', '1'},};
        System.out.println(maximalSquare(matrix));
    }
}
