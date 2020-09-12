public class NumberofSubstringsContainingAllThreeCharacters {
    public int numberOfSubstrings(String s) {
        int start = 0, end = 0, count = 0, characters = 0;
        int[] map = new int[3];
        for (; end <= s.length();) {
            if (characters == 3) {
                count += (s.length() - end + 1);
                char a = s.charAt(start++);
                if ((--map[a - 'a']) == 0) {
                    characters--;
                }
            } else {
                if (end < s.length()) {
                    char c = s.charAt(end);
                    if ((map[c - 'a']++) == 0) {
                        characters++;
                    }
                }
                end++;
            }
        }
        return count;
    }
    public int numberOfSubstrings2(String s) {
        int start = 0, count = 0, len = s.length();
        int[] map = new int[3];
        for (int end = 0; end < len; end++) {
            char c = s.charAt(end);
            map[c - 'a']++;
            while (map[0] > 0 && map[1] > 0 && map[2] > 0) {
                count += len - end;
                map[s.charAt(start++) - 'a']--;
            }
        }
        return count;
    }


    public void test(){
        System.out.println(numberOfSubstrings("abcabc"));
    }
}
