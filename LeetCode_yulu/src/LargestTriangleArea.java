public class LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        double ans = 0;
        int len = points.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    ans = Math.max(ans, area(points[i], points[j], points[k]));
                }
            }
        }
        return ans;
    }

    //本题的关键点就在于三角形面积的计算 0.5 * (x1y2 + x2y3 + x3y1 - x2y1 - x3y2 - x1y3)
    public double area(int[] P, int[] Q, int[] K) {
        return 0.5 * Math.abs(P[0] * Q[1] + Q[0] * K[1] + K[0] * P[1]
                - Q[0] * P[1] - K[0] * Q[1] - P[0] * K[1]);
    }

    public void test() {
        int[][] points = new int[][]{{0,0},{0,1},{1,0},{0,2},{2,0}};
        System.out.println(largestTriangleArea(points));
    }
}
