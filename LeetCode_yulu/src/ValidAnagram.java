import java.util.HashMap;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c,1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            } else if (map.get(c) == 1){
                map.remove(c);
            } else {
                map.put(c, map.get(c) - 1);
            }
        }
        return map.size() == 0;
    }

    public boolean isAnagram2(String s, String t) {
        int[] map = new int[26];
        int count = 0;
        for (int i= 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map[c - 'a']++;
            count++;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map[c - 'a'] == 0) {
                return false;
            }
            map[c - 'a'] --;
            count--;
        }
        return count == 0;
    }

    public void test() {
        System.out.println(isAnagram2("rat", "car"));
    }
}
