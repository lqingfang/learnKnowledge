package org.lqf.learn.leetCode.bfsAndDfs.ladderLength_127;

import javafx.util.Pair;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(ladderLength(beginWord,endWord,wordList));
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();
        int L = beginWord.length();
        wordList.forEach(
                word -> {
                    for(int i=0;i<L;i++) {
                        String newWord = word.substring(0,i)+"*"+word.substring(i+1,L);
                        List<String> orDefault = map.getOrDefault(newWord, new ArrayList<>());
                        orDefault.add(word);
                        map.put(newWord,orDefault);
                    }
                });
        Queue<Pair<String,Integer>> queue = new LinkedList<Pair<String, Integer>>();
        queue.add(new Pair<>(beginWord,1));

        Set<String> visitedSet = new HashSet<>();
        visitedSet.add(beginWord);

        while (!queue.isEmpty()) {
            Pair<String, Integer> poll = queue.remove();
            int level = poll.getValue();
            String key = poll.getKey();

            for(int i=0;i<L;i++) {
                List<String> adjWordList = map.getOrDefault(key.substring(0, i) + "*" + key.substring(i + 1, L), new ArrayList<>());

                for(int j=0;j<adjWordList.size();j++) {
                    if(adjWordList.get(j).equals(endWord)) {
                        return level+1;
                    }
                    if(!visitedSet.contains(adjWordList.get(j))) {
                        visitedSet.add(adjWordList.get(j));
                        queue.add(new Pair<>(adjWordList.get(j),level+1));
                    }
                }
            }
        }
        return 0;
    }
}
