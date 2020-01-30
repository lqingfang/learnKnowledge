package org.lqf.learn.leetCode.bfsAndDfs.letterCombinations_17;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

        System.out.println(letterCombinations("23"));
    }
    private static String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    private static ArrayList<String> res;
    public static List<String> letterCombinations(String digits) {
        res = new ArrayList<String>();
        if(digits.equals(""))
            return res;

        findCombination(digits, 0, "");
        return res;
    }

    private static void findCombination(String digits, int index, String s){
        if(index == digits.length()){
            res.add(s);
            return;
        }
        Character c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for(int i = 0 ; i < letters.length() ; i ++){
            findCombination(digits, index+1, s + letters.charAt(i));
        }
        return;
    }
}
