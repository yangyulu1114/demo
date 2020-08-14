public class ArrangingCoins {
    public int arrangeCoins(int n) {
        int count = 0;
        for (int i = 1; n > 0; i++) {
            if (n >= i) {
                count++;
            }
            n -= i;
        }

        return count;
    }
//这种方法因为有乘法运算，所以要注意越界的问题
    public int arrangeCoins2(int n) {
        long k = 1;
        for (; k * (k + 1) <= (2l * n); k++);
        return (int) (k - 1);
    }

    //这种方法是利用数学公式，k(k+1) * 2 <= n 所以 k(k+1) <= 2n; 所以k * k < 2n  k < sqrt(2n), 平方根算出来有可能是整数，这种情况k * (k + 1)就要大于2n了，所以最后要double check一下
    // 但是要注意(k+1) * (k + 1) 也有可能小于2n,所以result算出来还要再和ndouble check一下
//    这种方法也要同时考虑越界的问题

    public int arrangeCoins3(int n) {
        long targt = 2l * n;
        long result = (long) (Math.sqrt(targt));
        return (result * (result + 1) <= 2l * n) ? (int) (result) : (int) (result - 1);
    }

    public void test() {
        System.out.println(arrangeCoins3(1804289383));

//        System.out.println(arrangeCoins2(5));
    }
}
