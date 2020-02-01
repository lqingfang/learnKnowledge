package org.lqf.learn.leetCode.bfsAndDfs.letterCombinations_17;

import java.util.*;

/**
 * 回溯
 */
public class Solution03 {
    public static void main(String[] args) {

        System.out.println(letterCombinations("23"));
    }
    static Map<Character, List<Character>> mapper = new HashMap<Character, List<Character>>();
    static {
        mapper.put('2',Arrays.asList('a','b','c'));
        mapper.put('3',Arrays.asList('d','e','f'));
        mapper.put('4',Arrays.asList('g','h','i'));
        mapper.put('5',Arrays.asList('j','k','l'));
        mapper.put('6',Arrays.asList('m','n','o'));
        mapper.put('7',Arrays.asList('p','q','r','s'));
        mapper.put('8',Arrays.asList('t','u','v'));
        mapper.put('9',Arrays.asList('w','x','y','z'));
    }
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.equals("")) {
            return res;
        }
        dfs(digits, 0, "",res);
        return res;
    }

    private static void dfs(String digits, int index, String s,List<String> res){
        if(index == digits.length()) {
            res.add(new String(s));
            return;
        }
        List<Character> characterList = mapper.get(digits.charAt(index));
        for(int i=0;i<characterList.size();i++) {
            s += Character.toString(characterList.get(i));
            dfs(digits,index+1,s,res);
            s = s.substring(0,s.length()-1);
        }
    }
}
