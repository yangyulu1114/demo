import java.util.Arrays;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for(int j = i + 1; j <= s.length(); j++) {
                if (WithoutRepeatingCharacter(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    public boolean WithoutRepeatingCharacter(String s, int start, int end) {
        HashSet<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }
//slide window,时间复杂度n的平方
    public int lengthOfLongestSubstring2(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                } else {
                    break;
                }
            }
            ans = Math.max(ans, set.size());
        }
        return ans;
    }

    //slide window的优化版本，时间复杂度为n
    public int lengthOfLongestSubstring3(String s) {
        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0, j = 0; i <= s.length() && j < s.length();) {
            if (i == s.length() || set.contains(s.charAt(i))) {
                ans = Math.max(ans, set.size());
                set.remove(s.charAt(j++));
            } else {
                set.add(s.charAt(i++));
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring4(String s) {
        int ans = 0;
        int[] map = new int[128]; //这里保存的是每个字符有没有
        for(int i = 0, j = 0; j < s.length();) {
            if (map[s.charAt(j)] == 0) {
                ans = Math.max(ans, j - i + 1);
                map[s.charAt(j++)] = 1;
            } else {
                map[s.charAt(i++)] = 0;
            }
        }
        return ans;
    }
//5和4的版本的区别在于用start在代替i，这样不用每次一步一步地移动起始位置，可以直接移到未
    public int lengthOfLongestSubstring5(String s) {
        int ans = 0, count = 0, start = 0;
        int[] map = new int[128];  //注意这里要用128，因为没说字符一定是小写字符，这里保存的是每个字符最后一次出现的位置
        Arrays.fill(map, - 1);
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map[c] != -1) {
                start = Math.max(start,map[c] + 1);  //注意start可能早在重复字符的后面了，例如case"abba"
            }
            map[c] = i;
            count = i - start + 1;
            ans = Math.max(ans, count);
        }
        return ans;
    }

    public void test() {
        System.out.println(lengthOfLongestSubstring3("aab"));
    }
}
