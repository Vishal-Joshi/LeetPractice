package my.practice.ctci.datastructures;

/**
 * @author Vishal Joshi
 */
public class Trie {

    private final TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!currentNode.contains(c)) {
                TrieNode newNode = new TrieNode();
                currentNode.put(c, newNode);
            }
            currentNode = currentNode.get(c);
        }
        currentNode.setEnd(true);
    }

    public boolean search(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!currentNode.contains(c)) {
                return false;
            }
            currentNode = currentNode.get(c);
        }
        return currentNode.isEnd();
    }

    public boolean startsWith(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!currentNode.contains(c)) {
                return false;
            }
            currentNode = currentNode.get(c);
        }
        return true;
    }

    private class TrieNode {
        private TrieNode[] links;
        private boolean isEnd;

        TrieNode() {
            links = new TrieNode[26];
            isEnd = false;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public boolean contains(char c) {
            return links[c - 'a'] != null;
        }

        public TrieNode get(char c) {
            return links[c - 'a'];
        }

        public void put(char c, TrieNode nodeToInsert) {
            links[c - 'a'] = nodeToInsert;
        }
    }
}
