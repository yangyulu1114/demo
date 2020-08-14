public class ReverseString {
    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char temp = s[j];
            s[j] = s[i];
            s[i] = temp;
        }
    }

    public void test() {
        char[] input = new char[] {'h', 'e', 'l', 'l', 'o'};
        reverseString(input);
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }
}
