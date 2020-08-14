public class AddDigits {
    public int addDigits(int num) {
        int sum = num < 10 ? num : 0;
        while (num >= 10) {
            for (; num > 0; num = num / 10) {
                sum += num % 10;
            }
            num = sum;
            sum = 0;
//            sum 要记得每次清空，不然就会一直加下去
        }
        return num;
    }

    public void test() {
        System.out.println(addDigits(38));
    }
}
