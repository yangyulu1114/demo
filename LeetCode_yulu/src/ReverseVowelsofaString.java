import java.util.HashSet;

//要注意区分大小写
public class ReverseVowelsofaString {
    public String reverseVowels(String s) {
        char[] characters = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('A');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('o');
        set.add('O');
        set.add('u');
        set.add('U');


        for (int i = 0, j = characters.length - 1; i < j;) {
            if (set.contains(characters[i]) && set.contains(characters[j])) {
                char temp = characters[i];
                characters[i] = characters[j];
                characters[j] = temp;
                i++;
                j--;
                continue;
            }
            if (!set.contains(characters[i])) {
                i++;
            }
            if (!set.contains(characters[j])) {
                j--;
            }
        }
        return new String(characters);
    }

    public void test() {
        System.out.println(reverseVowels("leetcode"));
    }
}
