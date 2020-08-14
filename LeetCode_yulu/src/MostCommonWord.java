import java.util.HashMap;
import java.util.HashSet;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> set = new HashSet<>();
        for (String string : banned) {
            set.add(string);
        }
        paragraph = paragraph.toLowerCase();
        HashMap<String, Integer> map = new HashMap<>();
        int maxCount = 0;
        String ans = "";
        for (String string : paragraph.split("[\\s\\pP]")) {  //通过正则表达式进行multiple delimiters split
            if (string.isEmpty() || set.contains(string)) {
                continue;
            }
            int count = map.getOrDefault(string, 0) + 1;
            if (count > maxCount) {
                maxCount = count;
                ans = string;
            }
            map.put(string, count);
        }
        return ans;
    }

    public void test() {
        String[] banned = new String[] {"a"};
        System.out.println(mostCommonWord("a, a, a, a, b,b,b,c, c" , banned));
    }
}
