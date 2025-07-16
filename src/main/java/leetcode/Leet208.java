package leetcode;

class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}


class Trie {


    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char w : word.toCharArray()) {
            int index = w - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
        }
        node.isEnd = true;
    }


    public boolean search(String word) {
        TrieNode node = traverse(word);
        return node != null && node.isEnd;
    }

    public TrieNode traverse(String word) {
        TrieNode node = root;
        for (char w : word.toCharArray()) {
            int index = w - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

    public boolean startsWith(String prefix) {
        return traverse(prefix) != null;
    }
}

public class Leet208 {


}
