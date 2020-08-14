public class FindtheDifference {
    public char findTheDifference(String s, String t) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length();i++) {
            char c = t.charAt(i);
            if (--map[c - 'a'] < 0) {
                return c;
            }
        }
        return 'a';
    }

    public char findTheDifference2(String s, String t) {
        char a = t.charAt(0);
        for (int i = 0, j = 1; i < s.length() || j < t.length(); i++, j++) {
            if (i < s.length()) {
                a ^= s.charAt(i);
            }
            if (j < t.length()) {
                a ^= t.charAt(j);
            }
        }
        return a;
    }
}
