import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        int ans = 0;
        String[] moser = {".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.","---",".--.",
                "--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (Character c : word.toCharArray()) {
                sb.append(moser[c - 'a']);
            }
            if (set.add(sb.toString())) {  //注意这里一定得是string，而不是stringbuilder，不然每次的stringbuilder都会不一样
                ans++;
            }
        }
        return ans;
    }
    public int uniqueMorseRepresentations2(String[] words) {
        String[] moser = {".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.","---",".--.",
                "--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (Character c : word.toCharArray()) {
                sb.append(moser[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    public void test() {
        String[] words = new String[] {"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words));
    }
}
