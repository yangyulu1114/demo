public class SumofSquareNumbers {
    public boolean judgeSquareSum(int c) {
        for(int i = 0; i <= Math.sqrt(c); i++) {
            int remainder = c - i * i;
            int a = (int) Math.sqrt(remainder);
            if (a * a == remainder) {
                return true;
            }
        }
        return false;
    }

    public void test() {
        System.out.println(judgeSquareSum(3));
    }
}
