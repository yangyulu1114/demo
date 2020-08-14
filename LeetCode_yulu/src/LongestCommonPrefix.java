public class LongestCommonPrefix {


    // ["flower","flow","flight"]
    public String longestCommonPrefix5(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if (strs.length == 0) {
            return sb.toString();
        }
        for (int i = 0; ; i++) {
            char c = 0;
            for (int j = 0; j < strs.length; j++) {
                if (i >= strs[j].length()) {
                    return sb.toString();
                }
                char t = strs[j].charAt(i);
                if (c == 0) {
                    c = t;
                } else if (c != t) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
    }


    public String longestCommonPrefix4(String[] strs) {
        int commonprefix = 0;

        for (int i = 0; ; i ++) {
            boolean iscommon = true;
            for (int j = 0; j < strs.length && iscommon == true; j++) {
                if (i >= strs[j].length()) {
                    return strs[j];
                }

                iscommon = j == 0 ? true : strs[j-1].charAt(i) == strs[j].charAt(i);
            }

            if (iscommon && strs.length != 0) {
                commonprefix ++;
            } else {
                break;
            }
        }

        return (commonprefix == 0 ? "" : strs[0].substring(0,commonprefix));

    }


    public String longestCommonPrefix3(String[] strs) {
        int commonprefix = 0;

        for (int i = 0; i < strs.length; i ++) {

            commonprefix = (i == 0 ? strs[i].length() : getCommonprefix3(strs[i-1], commonprefix, strs[i]));

            if (commonprefix == 0) {
                return "";
            }
        }

        return (commonprefix == 0 ? "" : strs[0].substring(0,commonprefix));
    }

    public int getCommonprefix3(String l1, int length, String l2) {
        String commonprefix = "";
        int commonlength = 0;

        for (int i = 0; i < length && i < l2.length(); i++) {
            if (l1.charAt(i) == l2.charAt(i)) {
                commonlength++;
            } else {
                break;
            }
        }

        return commonlength;
    }

    public String longestCommonPrefix2(String[] strs) {
        String commonprefix = "";

        for (int i = 0; i < strs.length; i ++) {

            commonprefix = (i == 0 ? strs[i] : getCommonprefix2(commonprefix, strs[i]));

            if (commonprefix == "") {
                return commonprefix;
            }
        }

        return commonprefix;
    }

    public String getCommonprefix2(String l1, String l2) {
        String commonprefix = "";
        int commonlength = 0;

        for (int i = 0; i < l1.length() && i < l2.length(); i++) {
            if (l1.charAt(i) == l2.charAt(i)) {
                commonlength++;
            } else {
                break;
            }
        }

        return (commonlength == 0 ? "" : l1.substring(0,commonlength));
    }



    public String longestCommonPrefix(String[] strs) {
        String commonprefix = "";

        for (int i = 0; i < strs.length; i ++) {

            commonprefix = (i == 0 ? strs[i] : getCommonprefix(commonprefix, strs[i]));

            if (commonprefix == "") {
                return commonprefix;
            }
        }

        return commonprefix;
    }

    public String getCommonprefix(String l1, String l2) {
        String commonprefix = "";

        for (int i = 0; i < l1.length() && i < l2.length(); i++) {
            if (l1.charAt(i) == l2.charAt(i)) {
                commonprefix = commonprefix + l1.charAt(i);
            } else {
                break;
            }
        }

        return commonprefix;
    }

    public void test() {
        String[] strs = new String[0];
        System.out.println(longestCommonPrefix4(strs));
    }
}
