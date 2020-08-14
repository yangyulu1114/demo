import java.util.HashSet;

public class UglyNumber {
//    public boolean isUgly2(int num) {
//        long length = Math.abs((long) num) + 1;
//    这种方式太占空间了也很慢
//        boolean[] ugly = new boolean[length];
//        ugly[1] = true;
//        for (int i = 1; i * 2 <= num; i++) {
//            if (ugly[i]) {
//                ugly[i * 2] = true;
//                if (i * 3 <= num) {
//                    ugly[i * 3] = true;
//                }
//                if (i * 5 <= num) {
//                    ugly[i * 5] = true;
//                }
//            }
//        }
//        return ugly[num];
//    }

    public boolean isUgly(int num) {
        long length = Math.abs((long)num);
        HashSet<Long> set = new HashSet();
        set.add((long)1);

        for (long i = 1; i * 2 <= length; i++) {
            if (set.contains(i)) {
                set.add(i * 2);
                if (i * 3 <= length) {
                    set.add(i * 3);
                }
                if (i * 5 <= length) {
                    set.add(i * 5);
                }
            }
        }
        return set.contains(length);
    }
    public boolean isUgly2(int num) {
        if (num <= 0) {
            return false;
        }

        if (num % 2 == 0) {
            return isUgly(num / 2);
        } else if (num % 3 == 0){
            return isUgly(num / 3);
        } else if (num % 5 == 0) {
            return isUgly(num / 5);
        }

        return num == 1;
    }

    public void test() {
        System.out.println(isUgly2(-2147483648));
        System.out.println(Integer.MIN_VALUE);
    }
}
