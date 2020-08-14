import java.util.*;

public class MergeIntervals {
    //edge case[[1,3]]，本题需要注意的点，要注意最后一个interval要加进去，然后就是如果只有一个interval的情况
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] pre = intervals[0];
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i <= intervals.length; i++) {
            if (i == intervals.length) {
                list.add(new int[]{pre[0], pre[1]});
                break;
            }
            if (intervals[i][0] <= pre[1]) {
                pre[1] = Math.max(pre[1], intervals[i][1]);
            } else {
                list.add(new int[]{pre[0], pre[1]});
                pre[0] = intervals[i][0];
                pre[1] = intervals[i][1];
            }
        }
        return list.toArray(new int[list.size()][]);
    }
//上面的简化版本，只要没和前面的重合就加进去，如果和前面的重合了，就把最后加进去的数组的右区间修改掉
    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            int lastindex = list.size() - 1;
            if (list.isEmpty() || interval[0] > list.get(lastindex)[1]) {
                list.add(interval);
            } else {
                list.get(lastindex)[1] = Math.max(interval[1], list.get(lastindex)[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
