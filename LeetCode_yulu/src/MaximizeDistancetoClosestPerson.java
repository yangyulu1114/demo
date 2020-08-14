public class MaximizeDistancetoClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int max = 0, pre = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (pre == - 1) {
                    max = Math.max(max, i);
                } else {
                    max = Math.max(max, (i - pre) / 2);
                }
                pre = i;
            } else if (i == seats.length - 1) {
                max = Math.max(seats.length - 1 - pre, max);
            }
        }
        return max;
    }
}
