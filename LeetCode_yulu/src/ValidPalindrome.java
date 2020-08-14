public class ValidPalindrome {
//    public boolean isPalindrome(String s) {
//        boolean flag = true;
//        for (int i = 0, j = s.length() - 1; i < j && flag;) {
//            char head = s.charAt(i);
//            char tail = s.charAt(j);
//            if (!((head >= 'a' && head <= 'z') || (head >= 'A' && head <= 'Z') || (head >= '0' && head <= '9'))) {
//                i++;
//                continue;
//            }
//            if (!((tail >= 'a' && tail <= 'z') || (tail >= 'A' && tail <= 'Z') || (tail >= '0' && tail <= '9'))) {
//                j--;
//                continue;
//            }
//            flag = Math.abs(head - tail) ==  'A' - 'z' || head == tail;
//            i++;
//            j--;
//        }
//
//        return flag;
//    }

    public boolean isPalindrome2(String s) {
        s = s.toLowerCase();

        for (int i = 0, j = s.length() - 1; i < j;) {
            char head = s.charAt(i);
            char tail = s.charAt(j);
            if (!Character.isLetterOrDigit(head)) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(tail)) {
                j--;
                continue;
            }

            if (head != tail) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome3(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }
}
