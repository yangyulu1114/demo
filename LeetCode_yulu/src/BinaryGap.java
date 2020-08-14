public class BinaryGap {
    public int binaryGap(int N) {
        int ans = 0, index = -1, pre = -1;
        while (N != 0) {
            index++;
            if ((N & 1) == 1) {
                if (pre != -1) {
                    ans = Math.max(ans, index - pre);
                }
                pre = index;
            }
            N >>>= 1;
        }
        return ans;
    }
}
