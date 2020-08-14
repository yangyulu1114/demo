public class IsSubsequence {
//    public boolean isSubsequence(String s, String t) {
//        for (int i = 0; i < t.length() - s.length(); i++) {
//            int j = 0;
//            for (; j < s.length(); j++) {
//                if (s.charAt(j) != t.charAt(i + j)) {
//                    break;
//                }
//            }
//            if (j >= s.length()) {
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0 && t.length() == 0) {
            return true;
        }
        int i = 0, j = 0;
        for (; i < s.length() && j < t.length(); i++, j++) {
            for (; j < t.length() && s.charAt(i) != t.charAt(j); j++) ;
        }
        return i >= s.length() && j <= t.length();
    }

    public boolean isSubsequence2(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        for (int i = 0; i < t.length(); i++) {
            if (s.length() == 0) {
                return true;
            }
            if (s.charAt(0) == t.charAt(i)) {
                if (s.length() == 1) {
                    return true;
                }
                s.substring(1);
            }
        }
        return false;
    }

    public boolean isSubsequence3(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (t.indexOf(c) != -1) {
                t = t.substring(t.indexOf(c) + 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public void test() {
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }

//    edge case: "" ""
//    本题一定要注意t的一些临界条件，j在第二个循环中，如果找到了相等的数就不会+1了，所以在第一个循环中也要有一个+1操作，但是这样一来最后退出之后的判断条件就变成j <= t,length()了，
}
