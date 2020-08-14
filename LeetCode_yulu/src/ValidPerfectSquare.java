public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        long n = num;
        for (long i = 1, j = num; i <= j;) {
            long middle = (i + j) / 2;
            if (middle * middle == n) {
                return true;
            } else if (middle * middle < n) {
                i = middle + 1;
            } else {
                j = middle - 1;
            }
        }
        return false;
    }

    public void test() {
        System.out.println(isPerfectSquare(14));
    }
}
