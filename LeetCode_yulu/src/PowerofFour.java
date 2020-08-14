public class PowerofFour {
//    可以再看一下
    public boolean isPowerOfFour(int num) {
        if (num < 1) {
            return false;
        }
        while (num > 1) {
            if (num % 4 != 0) {
                return false;
            }
            num /= 4;
        }
        return true;
    }

    public boolean isPowerOfFour2(int num) {
        return Integer.toString(num, 4).matches("^10*$");
    }

    public void test() {
        System.out.println(isPowerOfFour2(5));
    }
}
