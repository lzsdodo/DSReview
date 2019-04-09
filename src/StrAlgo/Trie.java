package StrAlgo;

public class Trie {

    private TrieNode root = new TrieNode('/');

    public void insert(String word) {
        char[] chars = word.toLowerCase().toCharArray();
        TrieNode node = root;
        for (char c:chars) {
            int idx = c - 'a';
            if (node.childs[idx] == null) {
                node.childs[idx] = new TrieNode(c);
            }
            node = node.childs[idx];
        }
        node.isEnding = true;
    }

    public boolean find(String pattern) {
        char[] chars = pattern.toLowerCase().toCharArray();
        TrieNode node = root;
        for (char c:chars) {
            int idx = c - 'a';
            if (node.childs[idx] == null)
                return false;
            node = node.childs[idx];
        }
        return node.isEnding;
    }


    public class TrieNode {

        char       val;
        TrieNode[] childs;
        boolean    isEnding;

        public TrieNode(char c) {
            this.val      = c;
            this.childs   = new TrieNode[26];
            this.isEnding = false;
        }
    }

}
