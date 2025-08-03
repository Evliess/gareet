package leetcode;

class TNode {
    TNode[] children;
    boolean isEnd;

    public TNode() {
        children = new TNode[26];
        isEnd = false;
    }
}

class Trie {
    TNode root;

    public Trie() {
        root = new TNode();
    }

    public void insert(String word) {
        if (word == null || word.isEmpty())
            return;
        TNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null)
                node.children[index] = new TNode();
            node = node.children[index]; //记住修改node指向孩子节点
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TNode tnode = traverse(word);
        return tnode != null && tnode.isEnd;

    }

    public boolean startsWith(String prefix) {
        return traverse(prefix) != null;
    }

    public TNode traverse(String prefix) {
        if (prefix == null || prefix.isEmpty())
            return null;
        TNode node = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null)
                return null;
            node = node.children[index]; //记住修改node指向孩子节点
        }
        return node;

    }
}