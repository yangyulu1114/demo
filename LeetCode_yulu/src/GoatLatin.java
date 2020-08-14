public class GoatLatin {
    public String toGoatLatin(String S) {
        StringBuilder sb = new StringBuilder();
        String[] words = S.split(" ");
        for (int i = 0; i < words.length; i++) {
            char c = words[i].charAt(0);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A'
             || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                sb.append(words[i]).append("ma");
            } else {
                sb.append(words[i].substring(1)).append(c).append("ma");
            }
            for (int count = 0; count <= i; count++) {
                sb.append('a');
            }
            if (i != words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public void test() {
        System.out.println(toGoatLatin("I speak Goat Latin"));
    }
}
