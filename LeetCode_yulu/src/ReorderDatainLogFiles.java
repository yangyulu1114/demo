import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReorderDatainLogFiles {

    public String[] reorderLogFiles(String[] logs) {

        if (logs.length <=1) {
            return logs;
        }

        List<String> digits = new ArrayList<>();
        List<String> strings = new ArrayList<>();

        for (String tempt: logs) {
            String []words = tempt.split(" ");
            if (Character.isDigit(words[1].charAt(0))) {
                digits.add(tempt);
            } else {
                strings.add(tempt);
            }
        }

        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.substring(o1.indexOf(" ") + 1).compareTo(o2.substring(o2.indexOf(" ") + 1)) <= 0) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        strings.addAll(digits);

        return strings.toArray(new String[0]);
    }

    public void test() {
        String[] logs = {
                "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"
        };

        String[] result = reorderLogFiles(logs);
        for (String a : result) {
            System.out.println(a);
        }
    }

}
