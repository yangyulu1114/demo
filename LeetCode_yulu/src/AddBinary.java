public class AddBinary {
    public String addBinary(String a, String b) {
        String longString = a.length() > b.length() ? a : b;
        String shortString = a.length() > b.length() ? b : a;
        StringBuilder s = new StringBuilder();
        int increment = 0;

        for (int i = 1, shortlength = shortString.length(), longlength= longString.length(); i <= longlength; i++) {
            int shortnumber = i <= shortlength? shortString.charAt(shortlength - i) - '0' : 0;
            int longnumber = longString.charAt(longlength - i) - '0';
            s.append((shortnumber + longnumber + increment) % 2);
            increment = (shortnumber + longnumber + increment) / 2;
        }
        if (increment == 1) {
            s.append(increment);
        }
        return s.reverse().toString();
    }

    public String addBinary2(String a, String b) {
        StringBuilder s = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        //这种方法可以不用判断长短string了
        for (int flag = 0; i >= 0 || j >= 0 || flag > 0; i--, j--) {
            int k1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int k2 = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = k1 + k2 + flag;
            s.append(sum & 1);
            flag = sum >> 1;
        }
        return s.reverse().toString();
    }


    public void test() {
        System.out.print(addBinary2("1010", "1011"));
    }
}
