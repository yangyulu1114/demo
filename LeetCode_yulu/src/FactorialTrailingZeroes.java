public class FactorialTrailingZeroes {
//    public int trailingZeroes(int n) {
//        long result = 1;
//        for (; n > 0; n--) {
//            result *= n;
//        }
//        int number = 0;
//        for (;result > 0; result = result / 10) {
//            if (result % 10 == 0) {
//                number ++;
//            } else {
//                break;
//            }
//        }
//        return number;
//    }

    public int trailingZeroes(int n) {
        n -= n % 5;
        int result = 0;
//        可能会出现越界
        for (; n > 0; n -= 5) {
            int count = 0;
            for (int j = n ; j > 1 && j % 5 == 0; j /= 5, count++);
            result += count;
        }
        return result;
    }

    public int trailingZeroes2(int n) {
        n -= n % 5;
        int result = 0;
        for (long i = 5; i <= n; i *= 5) {
            result += n / i;
        }

        return result;
    }

    public void test() {
        System.out.println(trailingZeroes2(2147483647));
    }
}
