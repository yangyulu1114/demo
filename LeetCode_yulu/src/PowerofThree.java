public class PowerofThree {
//    注意这里问的是是否是3的次方，不是-3
//    循环的退出条件要注意是n > 1，而不是n > 0,因为1 是3的次方，但是1不能被3整除
    public boolean isPowerOfThree(int n) {
        for (; n > 1; n /= 3) {
            if (n % 3 != 0) {
                return false;
            }
        }
        return n > 0; //1是3的次方，0不是
    }
//可以先转成3进制，再看符不符合次方的形态
    public boolean isPowerOfThree2(int n) {
        return Integer.toString(n,3).matches("^10*$");
    }

    public void test() {
        System.out.println(isPowerOfThree2(45));
    }
}
