public class ReshapetheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length == 0 || (nums.length > 0 && (nums.length * nums[0].length != r * c))) {
            return nums;
        }
        int[][] matrix = new int[r][c];
        for(int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                int index = i * nums[i].length + j;
                matrix[index / c][index % c] = nums[i][j];
            }
        }
        return matrix;
    }

    public void test() {
        int[][] nums = new int[][]{{1,2,3,4}};
        int[][] output = matrixReshape(nums, 2, 2);
        for (int i = 0; i < output.length; i++) {
            for(int j = 0; j < output[i].length; j++) {
                System.out.print(output[i][j]);
                System.out.print(" ");
            }
            System.out.println(" ");
        }
    }
}
