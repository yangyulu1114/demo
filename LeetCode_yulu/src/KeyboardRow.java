import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class KeyboardRow {
    public String[] findWords(String[] words) {
        int[] map = new int[26];
        for (char i = 'a'; i <= 'z'; i = (char) (i + 1)) {
            map[i - 'a'] = Code(i);
        }
        List<String> list = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            int j = 0;
            for(; j < word.length() - 1; j++) {
                int code1 = map[word.charAt(j) - 'a'];
                int code2 = map[word.charAt(j + 1) - 'a'];
                if (code1 != code2) {
                    break;
                }
            }
            if (j >= words[i].length() - 1) {
                list.add(words[i]);
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public int Code(char i) {
        if ("qwertyuiop".indexOf(i) != -1) {
            return 1;
        } else if ("asdfghjkl".indexOf(i) != -1) {
            return 2;
        } else {
            return 3;
        }
    }

    public String[] findWords2(String[] words) {
        return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
    }

    public void test() {
        String[] input = new String[]{"asdfghjkl","qwertyuiop","zxcvbnm"};
        String[] output = findWords(input);
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }
}
