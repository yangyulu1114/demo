public class SmallestRangeI {
    public int smallestRangeI(int[] A, int K) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int n : A) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        return (max - min) <= K * 2 ? 0 : max - min - 2 * K;
    }
}
