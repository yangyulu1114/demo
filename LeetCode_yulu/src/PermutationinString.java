import java.util.Arrays;
import java.util.HashMap;

public class PermutationinString {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        HashMap<Character, Integer> count1 = new HashMap<>(), count2 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            count1.put(c, count1.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < len2; i++) {
            char c = s2.charAt(i);
            count2.put(c, count2.getOrDefault(c, 0) + 1);
            if (i >= len1) {
                char pre = s2.charAt(i - len1);
                if (count2.get(pre) == 1) {
                    count2.remove(pre);
                } else {
                    count2.put(pre, count2.get(pre) - 1);
                }
            }
            if (count2.equals(count1)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkInclusion2(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        int[] count1 = new int[26], count2 = new int[26];
        for (int c : s1.toCharArray()) {
            count1[c - 'a']++;
        }
        for (int i = 0; i < len2; i++) {
            char c = s2.charAt(i);
            count2[c - 'a']++;
            if (i >= len1) {
                count2[s2.charAt(i - len1) - 'a']--;
            }
            if (Arrays.equals(count1, count2)) {
                return true;
            }
        }
        return false;
    }


}
