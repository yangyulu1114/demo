public class SumofTwoIntegers {
    public int getSum(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        int sum = a ^ b;
        int increment = (a & b) << 1;
        return getSum(sum, increment);
    }

    public void test() {
        System.out.println(getSum(-2, 3));
    }
}
