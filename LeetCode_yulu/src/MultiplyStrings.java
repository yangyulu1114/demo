import java.util.List;

public class MultiplyStrings {

    //    要注意特俗情况：其中有一个数为0 例如：923 * 0
    public String multiply(String num1, String num2) {
        StringBuilder sum = new StringBuilder();
        for (int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder product = new StringBuilder();
            int increment = 0, currentsum = 0;
            for (int c = num2.length() - 1; c > i; c--, product.append(0));
            for (int j = num1.length() - 1; j >= 0 || increment > 0; j--) {
                int digit1 = num2.charAt(i) - '0';
                int digit2 = j >= 0 ? num1.charAt(j) - '0': 0;
                currentsum = digit1 * digit2 + increment;
                product.append(currentsum % 10);
                increment = currentsum / 10;
            }
            if (currentsum != 0) { //这一次乘积为0时，不用加
                sum = add(sum, product);
            }
        }
        return sum.length() == 0 ? "0" : sum.reverse().toString();  //如果sb为空，返回0
    }

    public StringBuilder add(StringBuilder num1, StringBuilder num2) {
        int increment = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0, j = 0; i < num1.length() || j < num2.length() || increment > 0; i++, j++) {
            int digit1 = i < num1.length() ? num1.charAt(i) - '0' : 0;
            int digit2 = j < num2.length() ? num2.charAt(j) - '0': 0;

            int sum = digit1 + digit2 + increment;
            sb.append(sum % 10);
            increment = sum / 10;
        }
        return sb;
    }

//    一定要小心结果等于0的情况

    public String multiply2(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] result = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j-- ) {
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';
                int sum = n1 * n2 + result[i + j + 1];
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0 || sb.length() > 0) {
                sb.append(result[i]);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public void test() {
        System.out.println(multiply2("123", "456"));
    }
}
