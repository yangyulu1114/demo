import java.util.HashMap;

public class LongestSubstringwithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int max = 0; //这里默认值要设为0，不能是整数最小值，因为s可能为空
        HashMap<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() > k) {
                c = s.charAt(start++);
                if (map.get(c) == 1) {
                    map.remove(c);
                } else {
                    map.put(c, map.get(c) - 1);
                }
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
