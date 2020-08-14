import java.util.Arrays;
import java.util.Comparator;

//其他几种方法也可以搞清楚，这种GREEDY是最优解
public class NonoverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int count = 0, pre = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < pre) {
                count++;
                pre = Math.min(pre, intervals[i][1]);  //这个pre值一定要注意，如果两个重叠，pre并不是不变，pre应该要选尾巴短一点的，而不是不变，因为有可能第二个出现的数组，start和end都小于pre，比如case[[1,100],[3,50],[80,120]]
            } else {
                pre = intervals[i][1];
            }
        }
        return count;
    }
}
