package org.lqf.learn.leetCode.bfsAndDfs.ladderLength_127;

import javafx.util.Pair;

import java.util.*;

public class Solution02 {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(ladderLength(beginWord,endWord,wordList));
    }
    static int L;
    static Map<String, List<String>> allComboDict = new HashMap<>();
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        L = beginWord.length();
        wordList.forEach(
                word -> {
                    for(int i=0;i<L;i++) {
                        String newWord = word.substring(0,i)+"*"+word.substring(i+1,L);
                        List<String> list = allComboDict.getOrDefault(newWord, new ArrayList<>());
                        list.add(newWord);
                        allComboDict.put(newWord,list);
                    }
                }
        );
        Queue<Pair<String,Integer>> Q_begin = new LinkedList<>();
        Queue<Pair<String,Integer>> Q_end = new LinkedList<>();

        Q_begin.add(new Pair<>(beginWord,1));
        Q_end.add(new Pair<>(endWord,1));

        HashMap<String,Integer> visitedBegin = new HashMap<>();
        HashMap<String,Integer> visitedEnd = new HashMap<>();
        visitedBegin.put(beginWord,1);
        visitedEnd.put(endWord,1);
        
        while (!Q_begin.isEmpty() && !Q_end.isEmpty()) {
            int ans = visitWordNode(Q_begin,visitedBegin,visitedEnd);
            if(ans >-1) {
                return ans;
            }
            ans = visitWordNode(Q_end,visitedEnd,visitedBegin);
            if(ans >-1) {
                return ans;
            }
        }
        return 0;
    }

    private static int visitWordNode(
            Queue<Pair<String, Integer>> Q,
            HashMap<String, Integer> visited,
            HashMap<String, Integer> othersVisited) {
        Pair<String, Integer> node = Q.remove();
        String word = node.getKey();
        int level = node.getValue();

        for (int i = 0; i < L; i++) {

            // Intermediate words for current word
            String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

            // Next states are all the words which share the same intermediate state.
            for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
                // If at any point if we find what we are looking for
                // i.e. the end word - we can return with the answer.
                if (othersVisited.containsKey(adjacentWord)) {
                    return level + othersVisited.get(adjacentWord);
                }

                if (!visited.containsKey(adjacentWord)) {

                    // Save the level as the value of the dictionary, to save number of hops.
                    visited.put(adjacentWord, level + 1);
                    Q.add(new Pair(adjacentWord, level + 1));
                }
            }
        }
        return -1;
    }
    private static int visited(Queue<Pair<String, Integer>> queue_start, Map<String, Integer> startMap, Map<String, Integer> endMap) {
        Pair<String, Integer> node = queue_start.remove();
        String key = node.getKey();
        int level = node.getValue();

        for(int i=0;i<L;i++) {
            String newWord = key.substring(0,i)+"*"+key.substring(i+1,L);
            List<String> list = allComboDict.getOrDefault(newWord, new ArrayList<>());
            for(String str : list) {
                if(endMap.containsKey(str)) {
                    return level+endMap.get(str);
                }
                if(!startMap.containsKey(str)) {
                    startMap.put(str,level+1);
                    queue_start.add(new Pair(str,level+1));
                }
            }
        }
        return -1;
    }
}
