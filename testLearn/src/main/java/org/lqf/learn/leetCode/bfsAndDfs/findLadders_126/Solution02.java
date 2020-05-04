package org.lqf.learn.leetCode.bfsAndDfs.findLadders_126;

import java.util.*;

public class Solution02 {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> list = Arrays.asList("hot","dot","dog","lot","log","cog");
        List<String> wordList = new ArrayList<>(list);
        System.out.println(findLadders(beginWord,endWord,wordList));
    }
    static List<List<String>> res = new ArrayList<>();
    static int L = 0;
    static Map<String,Set<String>> map = new HashMap<>();
    static Map<Integer,Set<String>> nxtMap = new HashMap<>(); // 记录每个搜索层次上的candidate节点
    static int minDist;
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) {
            return res;
        }
        wordList.add(beginWord);
        L = beginWord.length();
        for(int i=0;i<wordList.size()-1;i++) {
            for(int j=0;j<wordList.size();j++) {
                String a = wordList.get(i),b=wordList.get(j);
                if(check(a,b)) {
                    map.putIfAbsent(a, new HashSet<>());
                    map.putIfAbsent(b, new HashSet<>());
                    map.get(a).add(b);
                    map.get(b).add(a);
                }
            }
        }
        minDist = bfs(beginWord,endWord);
        //此时没有答案
        if(minDist == -1) {
            return res;
        }
        dfs(beginWord,endWord,new HashSet<String>(),new ArrayList<String>());

        return res;
    }

    private static void dfs(String cur, String endWord, HashSet<String> visit, ArrayList<String> path) {
        visit.add(cur);
        path.add(cur);
        if(minDist == path.size()) {
            if(cur.compareTo(endWord) == 0) {
                res.add(new ArrayList<>(path));
            }

        } else {
            for(String s:map.get(cur)){
                if(visit.contains(s) || !nxtMap.get(path.size()).contains(s)) {
                    continue;
                }
                dfs(s,endWord,visit,path);
            }
        }
        visit.remove(cur);
        path.remove(path.size()-1);
    }
    private static int bfs(String beginWord, String endWord) {
        int level = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            nxtMap.put(level+1,new HashSet<>());
            for(int i=0;i<size;i++) {
                String cur = queue.poll();
                if(cur.equals(endWord)) {
                    return level+1;
                }
                Set<String> curSet = map.getOrDefault(cur, new HashSet<>());
                for(String str:curSet) {
                    if(visited.contains(str)) {
                        continue;
                    }
                    visited.add(str);
                    queue.offer(str);
                    nxtMap.get(level+1).add(str);
                }
            }
            level++;
        }
        return -1;
    }

    public static boolean check(String a,String b) {
        int  index = 0;
        for(int i=0;i<L;i++) {
            if(a.charAt(i) != b.charAt(i)) {
                index++;
            }
        }
        return index == 1;
    }
}
