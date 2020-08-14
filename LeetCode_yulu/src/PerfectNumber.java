public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }
        int sum = 0;
        for (int i = (int) Math.sqrt(num); i > 0; i--) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        return sum + 1 == num;
    }

    public void test() {
        System.out.println(checkPerfectNumber(28));
    }
}
