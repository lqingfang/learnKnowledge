package org.lqf.learn.leetCode.backTrack.letterCasePermutation_784;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(letterCasePermutation("1a2b"));
    }
    static List<String> res = new ArrayList<>();
    public static List<String> letterCasePermutation(String S) {
        char[] chars = S.toCharArray();
        int size = chars.length;
        letter(chars,size,0);
        return res;
    }

    private static void letter(char[] chars, int size,int idx) {
        res.add(String.valueOf(chars));
        for(;idx<size;idx++) {
            if(Character.isDigit(chars[idx])) {
                continue;
            }else {
                chars[idx] = Character.toUpperCase(chars[idx]);
                letter(chars,size,idx+1);
                chars[idx] = Character.toLowerCase(chars[idx]);
            }
        }
    }
}
