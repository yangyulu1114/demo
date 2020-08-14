public class Base7 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        int a  = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        while (a > 0) {
            sb.append(a % 7);
            a /= 7;
        }
        if (num < 0) {
            sb.append('-');
        }
        return sb.reverse().toString();
    }

    public void test() {
        System.out.println(convertToBase7(-7));
    }
}
