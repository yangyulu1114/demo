public class FloodFill {
    //需要注意如果newcolor和image[sr][sc]值一样时，可能会陷入死循环，所以需要flag来判断是否已经替换过

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] flag = new boolean[image.length][image[0].length];
        floodFill(image, sr, sc, newColor, flag);
        return image;
    }
    public void floodFill(int[][] image, int sr, int sc, int newColor, boolean[][] flag) {
        int target = image[sr][sc];
        image[sr][sc] = newColor;
        flag[sr][sc] = true;
        if (sr > 0 && (!flag[sr - 1][sc]) && image[sr - 1][sc] == target) {
            floodFill(image, sr - 1, sc, newColor, flag);
        }
        if (sc > 0 && (!flag[sr][sc - 1]) && image[sr][sc - 1] == target) {
            floodFill(image, sr, sc - 1, newColor, flag);
        }
        if (sr < image.length - 1 && (!flag[sr + 1][sc]) && image[sr + 1][sc] == target) {
            floodFill(image, sr + 1, sc, newColor, flag);
        }
        if (sc < image[sr].length - 1 && (!flag[sr][sc + 1]) && image[sr][sc + 1] == target) {
            floodFill(image, sr, sc + 1, newColor, flag);
        }
    }

    //实际上当image[sr][sc] == newColor时，根本不需要任何替换操作了
    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        int target = image[sr][sc];
        if (target == newColor) {
            return image;
        }
        image[sr][sc] = newColor;
        if (sr > 0 && image[sr - 1][sc] == target) {
            floodFill2(image, sr - 1, sc, newColor);
        }
        if (sc > 0 && image[sr][sc - 1] == target) {
            floodFill2(image, sr, sc - 1, newColor);
        }
        if (sr < image.length - 1 && image[sr + 1][sc] == target) {
            floodFill2(image, sr + 1, sc, newColor);
        }
        if (sc < image[sr].length - 1 && image[sr][sc + 1] == target) {
            floodFill2(image, sr, sc + 1, newColor);
        }
        return image;
    }

    public void test() {
        int[][] input = new int[][]{{1,1,1}, {1,1,0}, {1,0,1}};
//        int[][] input = new int[][]{{0,0,0}, {0,1,1}};
        int[][] result =floodFill2(input, 1, 1, 2);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
