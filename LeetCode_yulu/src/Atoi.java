public class Atoi {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }

        boolean sign = str.charAt(0) == '-' ? false : true;
        int i = (str.charAt(0) == '+' || str.charAt(0) == '-') ? 1 : 0;

        long result = 0;
        for (; i < str.length() && result <= Integer.MAX_VALUE && result >= Integer.MIN_VALUE; i++) {
            char a = str.charAt(i);

            if (a <= '9' && a >= '0') {
                result = result * 10 + a - '0';
            } else {
                break;
            }
        }
        result = sign ? result : -result;

        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) result;
        }
    }

    public void test() {
        System.out.println(myAtoi("-47"));
    }
}
