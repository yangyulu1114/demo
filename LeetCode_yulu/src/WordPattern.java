import java.util.HashMap;
import java.util.HashSet;


//edge case："abba"  "dog dog dog dog" | "ab" "dog dog" 注意两边都是一一对应
//字符串相等不能直接用"="，要用equals
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] strings = str.split(" ");
        if (pattern.length() != strings.length) {
            return false;
        }
        HashMap<Character, String> mapChacracter = new HashMap<>();
        HashMap<String, Character> mapString = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (!mapChacracter.containsKey(c)) {
                mapChacracter.put(c, strings[i]);
            }
            if (!mapString.containsKey(strings[i])) {
                mapString.put(strings[i], c);
            }
            if (!mapChacracter.get(c).equals(strings[i]) || (!mapString.get(strings[i]).equals(c))) {
                return false;
            }
        }
        return true;
     }

     public void test() {
        System.out.println(wordPattern("ab", "dog dog"));
     }
}
