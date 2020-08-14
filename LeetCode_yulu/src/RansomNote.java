public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] characters = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            characters[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--characters[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
    public void test() {
        System.out.println(canConstruct("aa", "aab"));
    }

}
