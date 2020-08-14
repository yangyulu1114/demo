import java.util.HashMap;

public class DecodeWaysII {
    public int numDecodings(String s) {
        int M = 1000000007;
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Integer, Long> map = new HashMap<>();
        return (int )decode(0, s, map) % M ;
    }

    public long decode(int index, String s, HashMap<Integer, Long> map) {
        if (index == s.length()) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        if (index == s.length() - 1) {
            return s.charAt(index) == '*' ? 9 : 1;
        }
        if (map.containsKey(index)) {
            return map.get(index);
        }
        long count = decode(index + 1, s, map);
        if (s.charAt(index) == '*') {
            count *= 9;
        }
        if (s.charAt(index) != '*' && s.charAt(index + 1) != '*' &&
                (Integer.valueOf(s.substring(index, index + 2)) <= 26)) {
            count += decode(index + 2, s, map);
        }
        if (s.charAt(index) == '*' && s.charAt(index + 1) == '*') {
            count += (15 * decode(index + 2, s, map));
        }else if (s.charAt(index) == '1' && s.charAt(index + 1) == '*') {
            count += (9 * decode(index + 2, s, map));
        }else if (s.charAt(index) == '2' && s.charAt(index + 1) == '*') {
            count += (6 * decode(index + 2, s, map));
        }else if (s.charAt(index) == '*' && Integer.valueOf(s.substring(index + 1, index + 2)) <= 6) {
            count += (2 * decode(index + 2, s, map));
        }else if (s.charAt(index) == '*' && Integer.valueOf(s.substring(index + 1, index + 2)) > 6) {
            count += decode(index + 2, s, map);
        }
        map.put(index, count);
        return count;
    }

    public void test() {
        System.out.println(numDecodings("**********1111111111"));
    }
}
