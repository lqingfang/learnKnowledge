package org.lqf.learn.leetCode.bfsAndDfs.findLadders_126;

import java.util.*;

/**
 *
 */
public class Solution {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(findLadders(beginWord,endWord,wordList));
    }
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) {
            return Collections.emptyList();
        }
        int L = beginWord.length();
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        wordList.forEach(
                word -> {
                    for(int i=0;i<L;i++) {
                        String newWord = word.substring(0,i)+"*"+word.substring(i+1,L);
                        List<String> orDefault = map.getOrDefault(newWord, new ArrayList<String>());
                        orDefault.add(word);
                        map.put(newWord,orDefault);
                    }
                }
        );
        Queue<List<String>> queue = new LinkedList<>();
        queue.add(Arrays.asList(beginWord));

        boolean flag = false;
        while (!queue.isEmpty() && !flag) {
            int size = queue.size();
            for(int k=0;k<size;k++) {
                List<String> path = queue.remove();
                String key = path.get(path.size()-1);
                Set<String> subVisited = new HashSet<>();
                subVisited.addAll(path);
                for(int i=0;i<L;i++) {
                    String newWord = key.substring(0,i)+"*"+key.substring(i+1,L);
                    List<String> maplist = map.getOrDefault(newWord, new ArrayList<>());
                    for(String str:maplist) {
                        if(!subVisited.contains(str)) {
                            List<String> list = new ArrayList<>(path);
                            list.add(str);
                            if(str.equals(endWord)) {
                                flag = true;
                                res.add(list);
                                break;
                            }else {
                                subVisited.add(str);
                            }
                            if(!flag) {
                                queue.add(list);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
