package org.lqf.learn.leetCode.trieTree.trie_208;

public class TrieNode {
    public int num;
    public TrieNode[] son;
    public boolean isEnd;
    public char val;

    public TrieNode() {
        num = 1;
        isEnd = false;
        son = new TrieNode[26];
    }

    public TrieNode(char val) {
        this.val = val;
        num = 1;
        isEnd = false;
        son = new TrieNode[26];
    }
}
