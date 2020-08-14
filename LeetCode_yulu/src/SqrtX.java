public class SqrtX {
    public int mySqrt(int x) {
        long i = 0, j = x;
        while (i <= j) {
            long mid = (i + j) /2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                i = mid + 1;
            } else {
                j = mid -1;
            }
        }
        return (int) j;
    }

    public void test() {
        System.out.println(mySqrt(9));
    }
}
