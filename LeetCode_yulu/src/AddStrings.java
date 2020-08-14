public class AddStrings {
    public String addStrings(String num1, String num2) {
        int increment = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || increment > 0; i--, j--) {
            int digit1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j) - '0': 0;

            int sum = digit1 + digit2 + increment;
            sb.append(sum % 10);
            increment = sum / 10;
        }
        return sb.reverse().toString();
    }

    public void test() {
        System.out.println(addStrings("19", "19"));
    }
}

