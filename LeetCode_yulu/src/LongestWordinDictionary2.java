import java.util.HashMap;

public class LongestWordinDictionary2 {

    class Node {
        char c;
        HashMap<Character, Node> children = new HashMap<Character, Node>();
        int wordend;
        public Node(char c) {
            this.c = c;
        }
    }

    class Trie {
        Node root;
        public Trie() {
            root = new Node('0');
        }
        public void insert(String word, int index) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                cur.children.putIfAbsent(c, new Node(c));
                cur = cur.children.get(c);
            }
            cur.wordend = index;
        }
    }

    public String longestWord(String[] words) {
        Trie trie = new Trie();
        int index = 0;
        for (String word : words) {
            trie.insert(word, ++index);
        }
        return dfs(words, trie.root);
    }

    public String dfs(String[] words, Node root) {
        String ans = "";
        int index = root.wordend;
        if (index > 0) {
            ans = words[index - 1];
        }
        for (Node node : root.children.values()) {
            if (node.wordend > 0) {
                String s = dfs(words, node);
                if (s.length() > ans.length() || (s.length() == ans.length() && s.compareTo(ans) < 0)) {
                    ans = s;
                }
            }
        }
        return ans;
    }

}
