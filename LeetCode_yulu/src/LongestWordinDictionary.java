import java.util.HashSet;

public class LongestWordinDictionary {
    public String longestWord(String[] words) {
        String result = "";
        HashSet<String> set = new HashSet<>();
        for(String word : words ) {
            set.add(word);
        }
        for (String word : words) {
            int i = 1;
            for (; i < word.length(); i++) {
                String sub = word.substring(0, i);
                if (!set.contains(sub)) {
                    break;
                }
            }
            if (i == word.length()){
                if (result == "") {
                    result = word;
                } else {
                    if (word.length() > result.length()) {
                        result = word;
                    } else if (word.length() == result.length()) {
                        result = word.compareTo(result) < 0 ? word : result;
                    }
                }
            }
        }
        return result;
    }
//先判断长度能节省很大的计算量
    public String longestWord2(String[] words) {
        String result = "";
        HashSet<String> set = new HashSet<>();
        for(String word : words ) {
            set.add(word);
        }
        for (String word : words) {
            if (word.length() > result.length() || ((word.length() == result.length() && word.compareTo(result) < 0))) {
                int i = 1;
                for (; i < word.length(); i++) {
                    String sub = word.substring(0, i);
                    if (!set.contains(sub)) {
                        break;
                    }
                }
                if (i == word.length()) {
                    result = word;
                }
            }
        }
        return result;
    }
}
