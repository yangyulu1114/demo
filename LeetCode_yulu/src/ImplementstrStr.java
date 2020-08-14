public class ImplementstrStr {

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int index = -1, tempt = -1;

        for (int i = 0; i < haystack.length();i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                index = i;
                tempt = i;
            } else {
                continue;
            }

            int j = 0;

            for (; j < needle.length() && i < haystack.length(); i++, j++) {
                if (haystack.charAt(i) != needle.charAt(j)) {
                    index = -1;
                    break;
                }
            }

            if (j < needle.length() && i >= haystack.length()) {
                index = -1;
                break;
            }

            if (index != -1) {
                break;
            }

            i = tempt;

        }

        return index;
    }

    public int strStr2(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            for (int j = 0; j <= needle.length() && haystack.charAt(i + j) == needle.charAt(j); j++) {
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }

        return -1;
    }

    public void test() {
        System.out.println(strStr2("mississippi", "issip"));
    }
}
