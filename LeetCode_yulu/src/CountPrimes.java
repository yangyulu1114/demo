public class CountPrimes {
    public int countPrimes(int n) {
        int number = 0;
        for (int i = 2; i < n; i++) {
            int j = 2;
            for (; j <= i/2 & (i % j != 0); j++);
            number += j <= i / 2 ? 0 : 1;
        }
        return number;
    }

    public int countPrimes2(int n) {
        boolean[] Composite = new boolean[n]; //默认值为false
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (!Composite[i]) {
                count++; //本身就为合数时不用标记，因为合数都是某一个质数的倍数，用质数的倍数去标就能表到每一个数了，如果再用合数去标会重复计算
                for (int j = 2; i * j < n; j++) {
                    Composite[i * j] = true; //质数的倍数肯定为合数
                }
            }
        }
        return count;
    }

    public void test() {
        System.out.println(countPrimes2(10));
    }
}
