import java.util.HashMap;

public class RomantoInteger {

    //注意这个题目有一个点可以利用一下，就是一般来说罗马字符都是从大到小排列的，除了那六种情况之外，solution1里面就利用到了这点，即可以组队的六种情况
    public int romanToInt(String s) {
        int number = 0;

        char pre = '0';

        for (char c : s.toCharArray()) {
            switch (c) {
                case 'I':
                    number += 1;
                    pre = 'I';
                    break;

                case 'V':
                    number += (pre == 'I'? 3: 5);
                    pre = 'V';
                    break;

                case 'X':
                    number += (pre == 'I'? 8: 10);
                    pre = 'X';
                    break;

                case 'L':
                    number += (pre == 'X'? 30: 50);
                    pre = 'L';
                    break;

                case 'C':
                    number += (pre == 'X'? 80: 100);
                    pre = 'C';
                    break;

                case 'D':
                    number += (pre == 'C'? 300: 500);
                    pre = 'D';
                    break;

                case 'M':
                    number += (pre == 'C'? 800: 1000);
                    pre = 'M';
                    break;
            }
        }
        return number;
    }

    public void test() {
        System.out.println(romanToInt("MCMXCIV"));
    }

    //从左往右
    public int romanToInt1(String s) {
        HashMap<Character, Integer> values = new HashMap<>();
        values.put('M', 1000);
        values.put('D', 500);
        values.put('C', 100);
        values.put('L', 50);
        values.put('X', 10);
        values.put('V', 5);
        values.put('I', 1);

        int ans = 0;
        for (int i = 0; i < s.length(); ) {
            int currentValue = values.get(s.charAt(i));
            int nextValue = 0;
            if (i < s.length() - 1) {
                nextValue = values.get(s.charAt(i + 1));
            }

            if (currentValue < nextValue) {
                ans += (nextValue - currentValue);
                i += 2;
            } else {
                ans += currentValue;
                i++;
            }
        }
        return ans;
    }

    public int romanToInt2(String s) {
        HashMap<String, Integer> values = new HashMap<>();
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);
        values.put("CM", 900);
        values.put("CD", 400);
        values.put("XC", 90);
        values.put("XL", 40);
        values.put("IX", 9);
        values.put("IV", 4);

        int ans = 0;
        for (int i = 0; i < s.length(); ) {
            if (i < s.length() - 1) {
                String a = s.substring(i, i + 2);
                if (values.containsKey(a)) {
                    ans += values.get(a);
                    i += 2;
                    continue;
                }
            }
            ans += values.get(s.substring(i, i + 1));
            i++;
        }
        return ans;
    }
//从右往左
    public int romanToInt3(String s) {
        HashMap<Character, Integer> values = new HashMap<>();
        values.put('M', 1000);
        values.put('D', 500);
        values.put('C', 100);
        values.put('L', 50);
        values.put('X', 10);
        values.put('V', 5);
        values.put('I', 1);
        int lastValue = values.get(s.charAt(s.length() - 1)), ans = lastValue;
        for (int i = s.length() - 2; i >= 0; i--) {
            int currentValue = values.get(s.charAt(i));
            if (currentValue < lastValue) {
                ans -= currentValue;
            } else {
                ans += currentValue;
            }
            lastValue = currentValue;
        }
        return ans;
    }
}
