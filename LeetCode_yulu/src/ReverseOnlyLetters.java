public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        char[] sb = S.toCharArray();
        for (int i = 0, j = sb.length - 1; i < j;) {
            if (Character.isLetter(sb[i]) && Character.isLetter(sb[j])) {
                char temp = sb[i];
                sb[i] = sb[j];
                sb[j] = temp;
                i++;
                j--;
            } else if (!Character.isLetter(sb[i])){
                i++;
            } else {
                j--;
            }
        }
        return new String(sb);
    }

}
