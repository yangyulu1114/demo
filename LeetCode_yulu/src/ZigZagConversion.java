import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
    //这个方法就是安装Z字形依次去读，先将某个字符保存在对应的行的sb里，最后再拼接
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows);i++) {
            list.add(new StringBuilder());
        }
        boolean down = false;
        int currow = 0;
        for(char c : s.toCharArray()) {
            list.get(currow).append(c);
            if (currow == 0 || currow == numRows - 1) {
                down = !down;
            }
            currow += down ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : list) {
            result.append(sb);
        }
        return result.toString();
    }
    //第二种方法再研究下，第二种方法不用先保存，只用依次找到每一行的每个字符对应的位置，然后加到sb中，不用最后拼接

    public String convert2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        int lencycle = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; i + j < s.length(); j += lencycle) {
                result.append(s.charAt(i + j));
                if (i != 0 && i != numRows - 1 && j + lencycle - i < s.length()) {
                    result.append(s.charAt(j + lencycle - i));
                }
            }
        }
        return result.toString();
    }
}
