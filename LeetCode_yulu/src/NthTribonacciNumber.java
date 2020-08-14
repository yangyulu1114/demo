public class NthTribonacciNumber {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int tribonacci = 0, pre3 = 0, pre2 = 1, pre1 = 1;
        for (int i  = 3; i <= n; i++) {
            tribonacci = pre1 + pre2 + pre3;
            int temp = pre2;
            pre2 = pre1;
            pre3 = temp;
            pre1 = tribonacci;
        }
        return tribonacci;
    }

    public void test() {
        System.out.println(tribonacci(25));
    }
}
