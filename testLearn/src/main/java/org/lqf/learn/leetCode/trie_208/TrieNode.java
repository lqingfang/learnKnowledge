package org.lqf.learn.leetCode.trie_208;

public class TrieNode {
    public int num;
    public TrieNode[] son;
    public boolean isEnd;
    public char val;

    public TrieNode(char val) {
        this.val = val;
        num = 1;
        son = new TrieNode[26];
        isEnd = false;
    }

    TrieNode() {
        num = 1;
        son = new TrieNode[26];
        isEnd = false;
    }
}
