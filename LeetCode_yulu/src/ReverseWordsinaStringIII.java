public class ReverseWordsinaStringIII {
    public String reverseWords(String s) {
        s = s.trim();
        char[] string = s.toCharArray();
        int len = string.length;
        for (int i = 0, start = 0; i < len; i++) {
            if (string[i] == ' ' || i == len - 1) {
                int end = (i == len - 1) ? i : i - 1;
                reverse(string, start, end);
                start = i + 1;
            }
        }
        return new String(string);
    }
    public void reverse(char[] string, int start, int end) {
        for (; start < end; start++, end--) {
            char temp = string[end];
            string[end] = string[start];
            string[start] = temp;
        }
    }
}
