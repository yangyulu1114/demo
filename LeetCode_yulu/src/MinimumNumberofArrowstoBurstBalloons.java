import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberofArrowstoBurstBalloons {
    //GREEDY，以局部最优获得整体最优，往往会涉及到排序，排序时间复杂度O(NLOGN),排序之后时间复杂度是O(N)
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int arrows = 0, pre = 0;
        for (int i = 0; i < points.length; i++) {
            if (pre == 0 || points[i][0] > pre) {
                pre = points[i][1];
                arrows++;
            }
        }
        return arrows;
    }
}
