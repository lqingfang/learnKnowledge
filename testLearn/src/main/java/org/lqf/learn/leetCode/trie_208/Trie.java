package org.lqf.learn.leetCode.trie_208;

public class Trie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("abanana");
        print(root);
    }
    private static TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie_208. */
    public void insert(String word) {
        if(null == word || word.length() == 0) {
            return;
        }
        TrieNode node = root;
        for(int i=0;i<word.length();i++) {
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

    /** Returns if the word is in the trie_208. */
    public boolean search(String word) {
        if(null == word || word.length() == 0) {
            return false;
        }
        TrieNode node = root;
        for(int i=0;i<word.length();i++) {
            int pos = word.charAt(i)-'a';
            if(node.son[pos] == null) {
                return false;
            }
            node = node.son[pos];
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie_208 that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(null == prefix || prefix.length() == 0) {
            return false;
        }
        TrieNode node = root;
        for(int i=0;i<prefix.length();i++) {
            int pos = prefix.charAt(i)-'a';
            if(node.son[pos] == null) {
                return false;
            }
            node = node.son[pos];
        }
        return true;
    }
    public static void print(TrieNode root) {
        TrieNode[] node = root.son;
        for(int i=0;i<node.length;i++) {
            if(null != node[i]) {
                System.out.print(node[i].val+"-");
                print(node[i]);
                System.out.println();
            }
        }
    }
}
