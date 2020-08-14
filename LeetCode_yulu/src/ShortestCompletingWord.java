import java.util.Arrays;
import java.util.HashMap;

public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();
        String ans = "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (String word : words) {
            word = word.toLowerCase();
            boolean isComplete = true;
            for (char c : word.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            for (char c : licensePlate.toCharArray()) {
                if (Character.isLetter(c)) {
                    map.put(c, map.getOrDefault(c, 0) - 1);
                    if (map.get(c) < 0) {
                        isComplete = false;
                        break;
                    }
                }
            }
            if (isComplete && (ans == "" || word.length() < ans.length())) {
                ans = word;
            }
            map.clear();
        }
        return ans;
    }

    public String shortestCompletingWord2(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();
        String ans = "";
        int[] map = new int[26];
        for (String word : words) {
            word = word.toLowerCase();
            boolean isComplete = true;
            for (char c : word.toCharArray()) {
                map[c - 'a']++;
            }
            for (char c : licensePlate.toCharArray()) {
                if (Character.isLetter(c)) {
                    if (--map[c - 'a'] < 0) {
                        isComplete = false;
                        break;
                    }
                }
            }
            if (isComplete && (ans == "" || word.length() < ans.length())) {
                ans = word;
            }
            Arrays.fill(map, 0);
        }
        return ans;
    }

    public String shortestCompletingWord3(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();
        String ans = "";
        int[] map = new int[26];
        for (String word : words) {
            if (ans != "" && word.length() >= ans.length()) {
                continue;
            }
            word = word.toLowerCase();
            boolean isComplete = true;
            for (char c : word.toCharArray()) {
                map[c - 'a']++;
            }
            for (char c : licensePlate.toCharArray()) {
                if (Character.isLetter(c)) {
                    if (--map[c - 'a'] < 0) {
                        isComplete = false;
                        break;
                    }
                }
            }
            if (isComplete) {
                ans = word;
            }
        }
        return ans;
    }

    public void test() {
        String[] words = new String[]{"looks", "pest", "stew", "show"};
        System.out.println(shortestCompletingWord3("1s3 456", words));
    }
}
