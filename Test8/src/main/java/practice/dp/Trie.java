package practice.dp;

public class Trie {
    private Node root;

    public Trie() {
        root = new Node('\0');
    }

    public void insert(String str) {
        Node curr = root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Node(c);
                curr = curr.children[c - 'a'];
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String s) {
        Node node = getNode(s);
        return node != null && node.isWord;
    }

    public boolean startsWith(String s) {
        return getNode(s) != null;
    }


    public Node getNode(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                return null;
            }
            curr = curr.children[c - 'a'];
        }
        return curr;
    }

    class Node {
        public char c;
        public boolean isWord;
        public Node[] children;

        public Node(char c) {
            this.c = c;
            isWord = false;
            children = new Node[26];
        }
    }
}
