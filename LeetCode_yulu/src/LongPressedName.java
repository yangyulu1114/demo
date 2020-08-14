public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        if (typed.length() < name.length()) {
            return false;
        }
        int i = 0, j = 0;
        for (; i < name.length() && j < typed.length(); ) {
            if (typed.charAt(j) == name.charAt(i)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        if (i < name.length()) {
            return false;
        }
        for (; j < typed.length(); j++) {
            if (j > 0 && typed.charAt(j) != typed.charAt(j - 1)) {
                return false;
            }
        }
        return true;
    }
}
