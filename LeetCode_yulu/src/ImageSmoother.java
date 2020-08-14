public class ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        if (M.length == 0) {
            return M;
        }
        int lenX = M.length, lenY = M[0].length;
        int[][] result = new int[lenX][lenY];
        for (int i = 0; i < lenX; i++) {
            for (int j = 0; j < lenY; j++) {
                int sum = M[i][j], count = 1;
                if (j > 0) {
                    sum += M[i][j - 1];
                    count++;
                }
                if (i > 0) {
                    sum += M[i - 1][j];
                    count++;
                }
                if (i > 0 && j > 0) {
                    sum += M[i - 1][j - 1];
                    count++;
                }
                if (i > 0 && j < lenY - 1) {
                    sum += M[i - 1][j + 1];
                    count++;
                }
                if (j < lenY - 1) {
                    sum += M[i][j + 1];
                    count++;
                }
                if (i < lenX - 1 && j < lenY - 1) {
                    sum += M[i + 1][j + 1];
                    count++;
                }
                if (i < lenX - 1) {
                    sum += M[i + 1][j];
                    count++;
                }
                if (i < lenX - 1 && j > 0) {
                    sum += M[i + 1][j - 1];
                    count++;
                }
                result[i][j] = sum / count;
            }
        }
        return result;
    }
    public void test() {
        int[][]input = new int[][]{{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};
        int[][] result = imageSmoother(input);
        for(int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]);
                System.out.print(" ");
            }
            System.out.println(" ");
        }
    }
}
