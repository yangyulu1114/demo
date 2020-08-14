public class FibonacciNumber {
    public int fib(int N) {
        if (N == 0 || N == 1) {
            return N;
        }
        int pre1 = 1, pre2 = 0, fibonacci = 0;
//        注意这个公式，N >= 2时才成立
        for ( int i = 2; i <= N; i++) {
            fibonacci = pre1 + pre2;
            pre2 = pre1;
            pre1 = fibonacci;  //这两个赋值的顺序不能搞错啦
        }
        return fibonacci;
    }

    public void test() {
        System.out.println(fib(2));
    }
}
