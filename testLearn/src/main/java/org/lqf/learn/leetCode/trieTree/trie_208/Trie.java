package org.lqf.learn.leetCode.trieTree.trie_208;

public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        int len = word.length();
        TrieNode node = root;
        for(int i=0;i<len;i++) {
            int pos = word.charAt(i) - 'a';
            if(node.son[pos] == null) {
                node.son[pos] = new TrieNode(word.charAt(i));
            }else {
                node.son[pos].num++;
            }
            node = node.son[pos];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int len = word.length();
        TrieNode node = root;
        for(int i=0;i<len;i++) {
            int pos = word.charAt(i) - 'a';
            if(node.son[pos] == null) {
                return false;
            }
            node = node.son[pos];
        }
       return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int len = prefix.length();
        TrieNode node = root;
        for(int i=0;i<len;i++) {
            int pos = prefix.charAt(i) - 'a';
            if(node.son[pos] == null) {
                return false;
            }
            node = node.son[pos];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("abanana");
        System.out.println("1");
    }
}
