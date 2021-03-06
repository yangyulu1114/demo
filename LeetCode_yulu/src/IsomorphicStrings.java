import java.util.HashMap;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> map1 = new HashMap<>(), map2 = new HashMap<>() ;

        for (int i = 0; i < t.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
//            map1.put(c1, c2);
//            map2.put(c2, c1);
            if ((map1.containsKey(c1) && map1.get(c1) != c2 )|| (map2.containsKey(c2) && map2.get(c2) != c1)) {
                   return false;
            }
            map1.put(c1, c2);
            map2.put(c2, c1);
        }
        return true;
    }

    public void test() {
//"ab"
//"aa"
        HashMap<Character, Character> map = new HashMap<>();
//        map.put('a', 'b');
//        map.put('a', 'c');
//        System.out.println(map.get('a'));
        System.out.println(isIsomorphic("egg", "add"));
    }
}
