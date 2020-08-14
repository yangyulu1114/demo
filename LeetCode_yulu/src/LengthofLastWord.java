public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        //要防止数组越界
        return words.length > 0 ? words[words.length - 1].length() : 0;
    }

    public int lengthOfLastWord2(String s) {
        int length = 0;

        for (int j = s.length() - 1; j >= 0; j--) {
            if (s.charAt(j) != ' ') {
                length++;
            } else if(length > 0){
                break;
            }
        }
        return length;
    }

    public void test() {
        System.out.println(lengthOfLastWord2("a "));
    }
}
