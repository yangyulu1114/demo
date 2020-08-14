public class VerifyinganAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        int dic[] = new int[26];

        for (int i = 0; i < order.length(); i++) {
            dic [order.charAt(i) - 'a' ] = i;
        }

        for (int i = 0; i < words.length - 1; i ++) {
            boolean isSorted = compareWords (words[i], words[i+1], dic);
            if (!isSorted) {
                return false;
            }
        }

        return true;
    }

    public boolean compareWords (String word1, String word2, int[] dic) {
        int i = 0;
        for ( ; i < word1.length() && i < word2.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                return dic[word1.charAt(i) - 'a'] < dic[word2.charAt(i) - 'a'];
            }
        }
        return i < word1.length() ?  false : true;
    }

    public void test() {
        String[] words = {"ubg","kwh"};
        String order = "qcipyamwvdjtesbghlorufnkzx";
        System.out.println(isAlienSorted(words, order));

    }
}
