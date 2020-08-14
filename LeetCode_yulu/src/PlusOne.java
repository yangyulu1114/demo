public class PlusOne {
    public int[] plusOne(int[] digits) {
        Boolean needspace = true;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 9) {
                needspace = false;
                break;
            }
        }
        int tail = needspace ? digits.length : digits.length - 1;
        int[] result = new int[tail + 1];

        for (int increment = 1, j = digits.length - 1; j >=0; j--) {
            result[tail--] = (digits[j] + increment) % 10;
            increment = (digits[j] + increment)/10;
        }
        if (tail >= 0) {
            result[tail] = 1;
        }
        return result;
    }

    public int[] plusOne2(int[] digits) {
        int i = 0;
        for (; i < digits.length && digits[i] == 9; i++);
        int tail = i < digits.length ? digits.length - 1: digits.length;
        int[] result = new int[tail + 1];

        for (int increment = 1, j = digits.length - 1; j >=0; j--) {
            result[tail--] = (digits[j] + increment) % 10;
            increment = (digits[j] + increment)/10;
        }
        if (tail >= 0) {
            result[tail] = 1;
        }
        return result;
    }

    public void test() {
        int[] digits = new int[]{9,9};
        int[] output = plusOne2(digits);
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }
}
