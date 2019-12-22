package org.lqf.learn.leetCode.backTrack.diffWaysToCompute_241;

import java.util.ArrayList;
import java.util.List;

/**
 递归
 */
public class Solution {
    public static void main(String[] args) {
        String input = "2-1-1";
        System.out.println(diffWaysToCompute(input));
    }
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = partitioComputer(input);
        return res;
    }

    private static List<Integer> partitioComputer(String input) {
        List<Integer> res = new ArrayList<>();
        if(!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            res.add(Integer.valueOf(input));
            return res;
        }
        for(int i=0;i<input.length();i++) {
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                for(Integer left :partitioComputer(input.substring(0,i))){
                    for(Integer right :partitioComputer(input.substring(i+1))){
                        if(input.charAt(i) == '+') {
                            res.add(left+right);
                        }else if(input.charAt(i) == '-') {
                            res.add(left-right);
                        }else if(input.charAt(i) == '*') {
                            res.add(left*right);
                        }
                    }
                }
            }
        }
        return res;
    }
}
