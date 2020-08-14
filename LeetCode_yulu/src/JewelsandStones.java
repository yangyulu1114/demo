public class JewelsandStones {
    public int numJewelsInStones(String J, String S) {
        int[] Jmap = new int[58];
        int count = 0;
        for (char c : J.toCharArray()){
            Jmap[c - 'A'] = 1;
        }
        for (char c : S.toCharArray()) {
            if (Jmap[c - 'A'] == 1 ) {
                count++;
            }
        }
        return count;
    }
    public void test() {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }
}
