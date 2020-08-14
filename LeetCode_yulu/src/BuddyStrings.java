public class BuddyStrings {
    //要注意A和B完全相等的情况：edge case : "ab" "ab",  "aa" "aa"
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        if (A.equals(B)) {
            int[] count = new int[26];
            for (Character c : A.toCharArray()) {
                count[c - 'a']++;
            }
            for (int i = 0; i < count.length; i++) {
                if (count[i] >= 2) {
                    return true;
                }
            }
            return false;
        } else {
            int[] map = new int[2];
            int count = 0;
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt(i)) {
                    count++;
                    if (count > 2) {
                        return false;
                    }
                    map[count - 1] = i;
                }
            }
            return count == 0 || (count == 2 && A.charAt(map[0]) == B.charAt(map[1])
                    && A.charAt(map[1]) == B.charAt(map[0]));
        }
    }
    public void test() {
        System.out.println(buddyStrings("ab", "ba"));
    }
}
