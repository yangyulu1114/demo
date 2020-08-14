public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        for (; start < end && s.charAt(start) == s.charAt(end); start++, end--);
        if (start >= end) {
            return true;
        }
        int i = start + 1, j = end;
        for (; i < j && s.charAt(i) == s.charAt(j); i++, j--);
        if (i >= j) {
            return true;
        }

        for (i = start, j = end - 1; i < j && s.charAt(i) == s.charAt(j); i++, j--);
        return i >= j;
    }

}
