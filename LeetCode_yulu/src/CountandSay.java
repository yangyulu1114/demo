public class CountandSay {

    public String countAndSay2(int n) {
        StringBuilder sb = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            sb = countAndSay(sb);
        }
        return sb.toString();
    }

    public StringBuilder countAndSay(StringBuilder s) {
        char c = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == c) {
                count++;
            } else {
                if (c != 0) {
                    sb.append(count).append(c);
                }
                c = s.charAt(j);
                count = 1;
            }
        }

        return sb.append(count).append(c);
    }

    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        String result = sb.append(1).toString();

        for (int i = 1; i < n; i++) {
            char number = '0';
            int count = 0;
            sb.setLength(0);
            for (int j = 0; j < result.length(); j++) {
                if (result.charAt(j) == number) {
                    count++;
                } else {
                    if (number != '0') {
                        sb.append(count);
                        sb.append(number);
                    }
                    number = result.charAt(j);
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(number);
            result = sb.toString();
        }

        return result;
    }

    public void test() {
        System.out.println(countAndSay2(4));
    }
}
