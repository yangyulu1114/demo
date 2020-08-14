public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A.length == 0) {
            return new int[0][0];
        }
        int[][] ans = new int[A.length][B[0].length];
        for(int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    ans[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return ans;
    }

    //方法二和方法三相比，最后两个循环交换了顺序
    //这题的关键点在于方法二不是像方法一一样一步到位算出每个单元格的值，而是分步计算，由中间结果累加而成。而根据中间过中的A[i][j]==能过滤掉很多运算
    public int[][] multiply2(int[][] A, int[][] B) {
        int[][] ans = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < B[0].length; k++) {
                        ans[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }
        return ans;
    }
}
