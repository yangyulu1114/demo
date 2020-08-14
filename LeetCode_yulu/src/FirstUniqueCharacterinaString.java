import java.util.HashMap;
import java.util.HashSet;

public class FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        char[] map = new char[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar3(String s) {
        if (s.length() == 0) {
            return -1;
        }
        char[] map = new char[26];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
            if (map[s.charAt(index) - 'a'] > 1) {
                index++;
            }
        }

        for (; index < s.length(); index++) {
            if (map[s.charAt(index) - 'a'] == 1) {
                return index;
            }
        }
        return -1;
//        return map[s.charAt(index) - 'a'] == 1 ? index : -1;
    }
//edge case: "" "ll" "lab" "lla" "cccaabadb" 注意最后这个case，用方法3的时候要注意，因为到第一个b之后index一直没变，最后才发现b不是unique,但是这个时候已经退出循环了，index也就来不及变了
    public void test() {
        System.out.println(firstUniqChar3("cccaabadb"));
    }
}
