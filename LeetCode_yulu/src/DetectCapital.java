public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            count += Character.isUpperCase(c) ? 1 : 0;
        }
        return count == 0 || count == word.length() || (count == 1 && Character.isUpperCase(word.charAt(0)));
    }

    public void test() {
        System.out.println(detectCapitalUse("FlaG"));
    }
}
