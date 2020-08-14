public class FirstBadVersion {
    public int firstBadVersion(int n) {
        long i = 1, j = n;
        while (i < j) {
            long mid = (i + j)/2;
            if (isBadVersion((int)mid)) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return (int) i;
    }

    public boolean isBadVersion (int num) {
        return true;
    }
}
