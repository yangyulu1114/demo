public class FlippinganImage {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0, k = A[i].length - 1; j <= k; j++, k--) {
                int temp = A[i][j] == 1 ? 0 : 1;
                A[i][j] = A[i][k] == 1 ? 0 : 1;
                A[i][k] = temp;
            }
        }
        return A;
    }

    public void test() {
        int[][] input = new int[][]{{1,1,0},{1,0,1},{0,0,0}};
        int[][] output = flipAndInvertImage(input);
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                System.out.print(output[i][j]);
                System.out.print(" ");
            }
            System.out.println(" ");
        }
    }
}
