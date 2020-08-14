import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class StringCompression {
//    public int compress(char[] chars) {
////        int count[] = new int[128];
////        for (int i = 0; i < chars.length; i++) {
////            count[chars[i]]++;
////        }
////        int sum = 0, index = 0;
////        for (int i = 0; i < count.length; i++) {
////            int c = count[i];
////            if (c <= 0) {
////                continue;
////            }
////            chars[index++] = (char) i;
////            sum++;
////            if (c > 1) {
////                List<Character> list = new LinkedList<>();
////                for (; c > 0; sum++, c/= 10) {
////                    list.add((char) ('0' + c % 10));
////                }
////                for (int j = list.size() - 1; j >= 0; j--) {
////                    chars[index++] = list.get(j);
////                }
////            }
////        }
////        return sum;
//    }

//    本题一定要注意一些特殊情况
//    1、数组为空
//    2、每个字符都只出现一次'a', 'b', 'c'
//    3、最后一个字符什么时候填到新数组里
//    4、相同字符分开出现的情况
//      5、数字14加入到数组的顺序
    //6、数字转字符数组可以用tocharArray（）;


    public int compress(char[] chars) {
        if (chars.length <= 1 ) {
            return chars.length;
        }
        char pre_chacter = chars[0];
        int index = 0, count = 1;
        for (int i = 1; i <= chars.length; i++) {
            //出现新字符或者是到尾巴时再把旧字符或者是最后一个字符加入到数组里面，先加字符再加数字
            if (i == chars.length || chars[i] != pre_chacter) {
                chars[index++] = pre_chacter;
                if (i < chars.length) {
                    pre_chacter = chars[i];
                }
                if (count > 1) {
                    int num = 0;
                    for (int c = count; c > 0; c /= 10, num++) ;
                    for (int j = num - 1; j >= 0; j--, count/= 10) {
                        chars[index + j] = (char) ('0' + count % 10);
                    }
                    index += num;
                }
                count = 1;
            } else {
                count++;
            }
        }
        return index;
    }

    public int compress2(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) { //要擅于从index + 1和当前比较，而不是index 和index - 1比较
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }

    public void test() {
        char[] input = new char[]{'a', 'b', 'c'};
        int count = compress(input);
        for (int i = 0; i < count; i++) {
            System.out.println(input[i]);
        }
    }
}

