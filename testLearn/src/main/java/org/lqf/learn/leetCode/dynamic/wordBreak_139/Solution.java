package org.lqf.learn.leetCode.dynamic.wordBreak_139;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(wordBreak(s,wordDict));
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        //memo[i]表示s中以i-1结尾的字符串是否再wordDict中，两层循环，一点一点逼近，最后memo[len]就是答案
        boolean[] memo = new boolean[len+1];
        memo[0] = true;
        for(int i=1;i<=len;i++) {
            for(int j=0;j<i;j++) {
                if(memo[j] && wordDict.contains(s.substring(j,i))) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[len];
    }
}
