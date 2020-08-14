import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    //先将会议按时间排序，先给早开始的会议安排房间，将会议的结束时间记录到堆里
    //当要开下一个会时，先看最早要结束的会是否有结束，如果结束了，就用之前申请的房间继续开会，记录新的结束时间，如果没有结束，则申请新的房间
    //最后就是看堆里有几个房间就是结果了。
    //时间复杂度是O（nlogn）
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int[] interval : intervals) {
//            if (queue.isEmpty() || interval[0] < queue.peek()) {
//                queue.add(interval[1]);
//            } else {
//                queue.poll();
//                queue.add(interval[1]);
//            }
            if (!queue.isEmpty() && interval[0] >= queue.peek()) {
                queue.poll();
            }
            queue.add(interval[1]);
        }
        return queue.size();
    }

    //时间序列，将开始时间和结束时间分开处理排序，每次会议开始时，先去看有没有会议结束，如果starts[start_ptr] >= ends[end_ptr],则说明有会议结束，
    // 可以复用会议室，否则就得申请新的会议室
    public int minMeetingRooms2(int[][] intervals) {
        int[] starts = new int[intervals.length], ends = new int[intervals.length];
        int index = 0;
        for (int[] interval : intervals) {
            starts[index] = interval[0];
            ends[index++] = interval[1];
        }
        Arrays.sort(starts); Arrays.sort(ends);
        int count = 0;
        for (int start_ptr = 0, end_ptr = 0; start_ptr < starts.length; start_ptr++) {
            if (starts[start_ptr] < ends[end_ptr]) {
                count++;
            } else {
                end_ptr++;
            }
        }
        return count;
    }
}
