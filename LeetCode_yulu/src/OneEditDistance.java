public class OneEditDistance {
    //要注意，前面都相同，只有最后多一个字母的情况，例如case s = "", t = "a" 和 case s = "a", t = "ac"
    public boolean isOneEditDistance(String s, String t) {
        int slen = s.length(), tlen = t.length();
        if (slen > tlen) {
            return isOneEditDistance(t, s);
        }
        if (tlen - slen > 1) {
            return false;
        }
        int count = 0, i = 0, j = 0;
        for (; i < slen && j < tlen; j++) {
            char a = s.charAt(i), b = t.charAt(j);
            if (a != b) {
                count++;
            }
            if (a == b || slen == tlen || count > 1) {
                i++;
            }
        }
        return count == 1 || count == 0 && j == tlen - 1;
    }

    public boolean isOneEditDistance2(String s, String t) {
        int slen = s.length(), tlen = t.length();
        if (slen > tlen) {
            return isOneEditDistance(t, s);
        }
        if (tlen - slen > 1) {
            return false;
        }
        int count = 0, i = 0, j = 0;
        for (; i < slen && j < tlen; j++) {
            char a = s.charAt(i), b = t.charAt(j);
            if (a != b) {
                count++;
            }
            if (count > 1) {
                return false;
            }
            if (a == b || slen == tlen) {
                i++;
            }
        }
        return count == 1 || count == 0 && j == tlen - 1;
    }

    public boolean isOneEditDistance3(String s, String t) {
        int slen = s.length(), tlen = t.length();
        if (slen > tlen) {
            return isOneEditDistance(t, s);
        }
        if (tlen - slen > 1) {
            return false;
        }
        for (int i = 0; i < slen; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (slen == tlen) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        return tlen - slen == 1;  //这种方法要注意两个字符串完全一样的情况
    }

    public void test() {
        System.out.println(isOneEditDistance("a", ""));
    }
}
