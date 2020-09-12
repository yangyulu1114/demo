import java.util.ArrayList;
import java.util.List;

public class LongestWordinDictionarythroughDeleting {
    public String findLongestWord(String s, List<String> d) {
//        Collections.sort(d, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return  o1.compareTo(o2);
//
//            }
//        });
        String ans = "";
        for (int i = 0; i < d.size(); i++) {
            String string = d.get(i);
            if ((string.length() > ans.length())|| (string.length() == ans.length() && string.compareTo(ans) < 0)) {
                if (ispossibleresult2(string, s)) {
                ans = string;
                }
            }
        }
        return ans;
    }
    //这个函数的时间复杂度是O(s的长度 * string的长度)
    public boolean ispossibleresult(String string, String s) {
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            int index = s.indexOf(c);
            if (index == -1) {
                return false;
            }
            s = s.substring(index + 1);
        }
        return true;
    }

    //这个函数的时间复杂度是O(s的长度 + string的长度)
    public boolean ispossibleresult2(String string, String s) {
        int j = 0;
        for (int i = 0; i < s.length() && j < string.length(); i++) {
            if (s.charAt(i) == string.charAt(j)) {
                j++;
            }
        }
        return j >= string.length();
    }

    public void test() {
        String[] d = new String[]{"ale","apple","monkey","plea"};
        List<String> list = new ArrayList<>();
        for (String string : d) {
            list.add(string);
        }
        System.out.println(findLongestWord("abpcplea", list));
    }
}
