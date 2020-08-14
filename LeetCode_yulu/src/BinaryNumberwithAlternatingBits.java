public class BinaryNumberwithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int pre_digit = n & 1;
        for (n >>>= 1; n > 0; n >>>= 1) {
            int digit = n & 1;
            if (pre_digit == digit) {
                return false;
            }
            pre_digit = digit;
        }
        return true;
    }

    public void test() {
        System.out.println(hasAlternatingBits(10));
    }
}
