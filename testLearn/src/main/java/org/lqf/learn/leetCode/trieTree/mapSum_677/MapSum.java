package org.lqf.learn.leetCode.trieTree.mapSum_677;

public class MapSum {
    public MapSum() {

    }
    TrieNode root = new TrieNode();
    public void insert(String key, int val) {
        TrieNode node = root;
        for (int i=0;i<key.length();i++) {
            int pos = key.charAt(i)-'a';
            if(node.children[pos] == null) {
                node.children[pos] = new TrieNode();
            }
            node = node.children[pos];
        }
        node.val = val;
    }

    public int sum(String prefix) {
        TrieNode node = root;
        //这块是判断是否存在以prefix开头的值，
        //如果没有，断掉了，则返回0
        for (int i=0;i<prefix.length();i++) {
            int pos = prefix.charAt(i)-'a';
            if(node.children[pos] != null) {
                node = node.children[pos];
            } else {
                return 0;
            }

        }
        return getSum(node);
    }

    private int getSum(TrieNode node) {
        int sum = node.val;
        for(int i=0;i<node.children.length;i++) {
            if(null != node.children[i]) {
                sum += getSum(node.children[i]);
            }
        }
        return sum;
    }
}
