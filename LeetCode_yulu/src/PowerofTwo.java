public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
//      注意最高位为1时表示的是负数，负数都应该是false，因为2的次方都是大于0的
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    public void test() {
        System.out.println(isPowerOfTwo(0));
    }
}
